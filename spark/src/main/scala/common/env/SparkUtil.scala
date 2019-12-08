package common.env

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description TODO
  * @Author BiChengfei
  * @Date 2019/11/17 15:17
  **/
object SparkUtil {

  def getSc(): SparkContext ={
    val conf = new SparkConf().setAppName("first").setMaster("local[2]")
    new SparkContext(conf)
  }

  def getSparkSession(): SparkSession ={
    SparkSession.builder().appName("second").master("local[2]").getOrCreate()
  }

}
