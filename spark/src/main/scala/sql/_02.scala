package sql

import common.env.SparkUtil
import org.apache.spark.sql.SaveMode

case class Record(key: Int,value: String)

object _02 {

  def main(args: Array[String]): Unit = {
    val spark = SparkUtil.getSparkSession()

    import spark.implicits._

    val df = spark.createDataFrame((1 to 100).map(i => Record(i,s"val_$i")))

    df.createOrReplaceTempView("records")

    println("Result of select *:")
    spark.sql("select * from records").collect().foreach(println)

    val count = spark.sql("select count(*) from records").collect().head.getLong(0)
    println(s"count(*): $count")

    val rddFromSql = spark.sql("select key,value from records where key < 10")
    println("result of rdd.map:")
    rddFromSql.rdd.map(row => s"key: ${row(0)},value:${row(1)}").collect().foreach(println)

    df.where($"key" === 1).orderBy($"value".asc).select($"key").collect().foreach(println)

    df.write.mode(SaveMode.Overwrite).parquet("pair.parquet")

    val parquetFile = spark.read.parquet("pair.parquet")

    spark.stop()
  }
}
