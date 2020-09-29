package sql

import common.FilePath
import common.env.SparkUtil
import org.apache.spark.sql.SparkSession

object _03 {

  def main(args: Array[String]): Unit = {
    val spark = SparkUtil.getSparkSession()

    _01(spark)
  }

  private def _01(spark: SparkSession): Unit = {
    val usersDF = spark.read.parquet("D:\\own\\project\\myself\\spark\\src\\main\\resources\\static\\users.parquet")
    usersDF.select("name","favorite_color").write.save("namesAndFavColors.parquet")

    val peopleDF = spark.read.format("json").load(FilePath.json)
    peopleDF.select("name","age").write.format("parquet").save("namesAndAges.parquet")

    val peopleDFCSV = spark.read.format("csv")
      .option("sep",";")
      .option("inferSchema","true")
      .option("header","true")
      .load(FilePath.csv)

    usersDF.write.format("orc")
      .option("orc.bloom.filter.columns","favorite_color")
      .option("orc.dictionary.key.threshold","1.0")
      .save("users_with_options.orc")

    val sqlDF = spark.sql(s"select * from parquet.`${FilePath.parquet}`")

    peopleDF.write.bucketBy(42,"name").sortBy("age").saveAsTable("people_bucketde")

    usersDF.write.partitionBy("favorite_color").format("parquet").save("namesPartByColor.parquet")

    usersDF
      .write
      .partitionBy("favorite_color")
      .bucketBy(42,"name")
      .saveAsTable("users_partitioned_bucketed")

    spark.sql("drop table if exists people_bucketed")
    spark.sql("drop table if exists users_partitioned_bucketed")


  }
}
