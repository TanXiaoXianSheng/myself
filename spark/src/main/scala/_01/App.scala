package _01

import common.env.SparkUtil
import org.apache.spark.rdd.RDD

/**
  * @Description TODO
  * @Author BiChengfei
  * @Date 2019/11/17 15:06
  **/
object App {

  val sc = SparkUtil.getSc()

  def first(): Unit ={
    val data = Array(1,2,3,4,5)
    sc.parallelize(data)
  }

  def second(): RDD[String] ={
    sc.textFile("D:\\software\\worksoft\\spark-2.4.7-bin-hadoop2.7\\spark-2.4.7-bin-hadoop2.7\\spark-2.4.7-bin-hadoop2.7\\README.md")
  }

  def third(): Unit ={
    val lineLengths = second().map(x => x.length)
    val totalLength = lineLengths.reduce((a,b) => a + b)
    print(totalLength)
  }

  def fourth(): Unit ={
    val words = second().flatMap(line => {
      line.split(" ")
    })
    val pairs = words.map(word => (word,1))
    val wordCount = pairs.reduceByKey((a,b) => a + b)
    //val wordCount = pairs.reduce((a,b) => (a._1,a._2+b._2))
    val b = 1
  }

  def main(args: Array[String]): Unit = {
    fourth()
  }

}
