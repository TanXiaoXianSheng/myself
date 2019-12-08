package spark_streaming_kafka

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.KafkaUtils

/**
  * @Description TODO
  * @Author BiChengfei
  * @Date 2019/11/6 11:28
  **/
class DirectStream {

  val kafkaParams = Map[String,Object](
    "bootstrap.servers" -> "192.168.9.8:9092,192.168.9.9:9092,192.168.9.10:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "test001",
    "auto.offset.reset" -> "latest",
    "enable.auto.commit" -> (false)
  )

  val topics = Array("test")


}
