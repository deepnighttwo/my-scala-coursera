package common

object TestScala {

  def main(args: Array[String]): Unit = {
    val asdf:Null = null
    val asdfasdfsadf = Seq("")

    val myMap = Map(1->"One")
    val myNewMap = myMap updated(1, "one one one")

    println (myMap get 1)
    println (myNewMap get 1)
  }


}
