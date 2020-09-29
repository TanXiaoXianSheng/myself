package sql

import common.FilePath
import common.env.SparkUtil
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object _01 {

  case class Person(name: String, age: Long)

  def main(args: Array[String]): Unit = {
    val spark = SparkUtil.getSparkSession()
    //_01(spark)
    //_02(spark)
    //_03(spark)
    _04(spark)
  }

  private def _01(spark: SparkSession): Unit = {
    val df = spark.read.json(FilePath.json);
    df.printSchema()

    df.select("name").show()

    import spark.implicits._
    df.select($"name",$"age" + 1).show();

    df.filter($"age" > 21).show()

    df.groupBy("age").count().show()

    df.createOrReplaceTempView("people")
    val sqlDF = spark.sql("select * from people")
    sqlDF.show()

    df.createGlobalTempView("people")
    spark.sql("select * from global_temp.people").show()
    spark.newSession().sql("select * from global_temp.people").show()
  }

  private def _02(spark: SparkSession): Unit = {
    import spark.implicits._
    val caseClassDs = Seq(Person("Andy",32)).toDS()
    caseClassDs.show;

    val primitiveDS = Seq(1,2,3).toDS()
    primitiveDS.map(_ + 1).show()

    val peopleDS = spark.read.json(FilePath.json).as[Person]
    peopleDS.show()

  }

  private def _03(spark: SparkSession): Unit = {
    import spark.implicits._
    val peopleDF = spark.sparkContext
      .textFile(FilePath.txt)
      .map(_.split(","))
      .map(attributes => Person(attributes(0),attributes(1).trim.toInt))
      .toDF()

    peopleDF.createOrReplaceTempView("people")

    val teenagesDF = spark.sql("select name,age from people where age between 13 and 19")
    teenagesDF.map(teenager => "name: " + teenager(0)).show()

    teenagesDF.map(teenager => "names: " + teenager.getAs[String]("name")).show()

    implicit  val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String,Any]]
    teenagesDF.map(teenager => teenager.getValuesMap[Any](List("name","age")))
  }

  private def _04(spark: SparkSession): Unit = {
    import spark.implicits._
    val peopleRDD = spark.sparkContext.textFile(FilePath.txt)

    val schemaString = "name age"

    val fields = schemaString.split(" ")
      .map(fieldName => StructField(fieldName, StringType, nullable = true))
    val schema = StructType(fields)

    val rowRDD = peopleRDD
      .map(_.split(","))
      .map(attribute => Row(attribute(0),attribute(1).trim))

    val peopleDF = spark.createDataFrame(rowRDD,schema)

    peopleDF.createOrReplaceTempView("people")

    val results = spark.sql("select name from people")

    results.map(attribute => "name: " + attribute(0)).show()

  }
}
