package funfunc

object FunFunc {

  def main(args: Array[String]): Unit = {
    val myList = "" :: "" :: "" :: Nil
    println("")
  }

  def exampleVal = System.currentTimeMillis()

  val fixVal = System.currentTimeMillis()

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumf(a: Int, b: Int): Int = {
      var sumall = 0
      for (i <- a to b) {
        sumall += f(i)
      }
      sumall
    }

    sumf
  }


}
