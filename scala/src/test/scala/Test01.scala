import org.junit.Test

/**
  * @Description TODO
  * @Author BiChengfei
  * @Date 2019/9/30 15:14
  **/
@Test
class Test01 {

  @Test
  def test001: Unit ={
    println("1111")
  }

  @Test
  def test02: Unit ={
    val map1 = Map("a" -> 1,"b" -> 2,"c" -> 2)
    val map2 = Map("a" -> 2,"b" -> 5,"d" -> 9)
    val map3 = map1 ++ map2
    println(map3.addString(new StringBuilder()))
  }

  @Test
  def test03: Unit ={
    val directMap = Map(
      "201台" -> "201",
      "202台" -> "202",
      "203台" -> "203",
      "281台" -> "281",
      "282台" -> "282",
      "291台" -> "291",
      "292台" -> "292",
      "293台" -> "293",
      "553台" -> "553",
      "573台" -> "573",
      "成都台" -> "cd",
      "西安台" -> "xa",
      "海南台" -> "hn",
      "厦门台" -> "xm",
      "哈尔滨台" -> "heb"
    )
    print(directMap.keySet.mkString("('","','","')"))
  }

  @Test
  def test04: Unit = {
    val numbers = Map("one" -> 1, "two" -> 2, "three" -> 3)
    val airports = Map("arrival" -> "Otopeni", "SFO" -> "San Fran")


  }
}


