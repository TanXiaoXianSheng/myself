package _02

import common.env.SparkUtil
import org.apache.spark.sql.DataFrame

/**
  * @Description TODO
  * @Author BiChengfei
  * @Date 2019/11/18 15:02
  **/
object App {

  val session = SparkUtil.getSparkSession()

  val df = session.read.json("F:\\person\\project\\myself\\spark\\src\\main\\resources\\people.json")


  def main(args: Array[String]): Unit = {

  }
}
