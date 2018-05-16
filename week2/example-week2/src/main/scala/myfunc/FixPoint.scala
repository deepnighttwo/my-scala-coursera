package myfunc

object FixPoint {

  def main(args: Array[String]): Unit = {
    println(fixPoint(avgFunc(x => 1 + x / 2))(1))
    println(fixPoint(avgFunc(x => 1 + x / 2))(1))

    def sqrt(x: Double) = fixPoint(avgFunc(y => x / y))(1)

    println(sqrt(9))
  }


  def avgFunc(f: Double => Double)(x: Double) = {
    (x + f(x)) / 2
  }

  def fixPoint(f: Double => Double)(guess: Double): Double = {
    val next = f(guess)
    if (closeEnough(guess, next)) {
      next
    } else {
      fixPoint(f)(next)
    }
  }


  def closeEnough(x: Double, y: Double) = {
    math.abs((x - y) / x) < 0.000001
  }


}
