package funfunc

object MySqrt {
  def main(args: Array[String]): Unit = {
    val x = 1.0e50
    val ret = sqrt(x)
    println(x + "  " + (ret * ret))
  }

  def sqrt(x: Double): Double = {

    def isGoodGuess(guess: Double): Boolean = {
      Math.abs(x - guess * guess) < x * 1e-10
    }


    def improve(guess: Double): Double = {
      (x / guess + guess) / 2
    }

    def sqrtIt(guess: Double): Double = {
      if (isGoodGuess(guess)) {
        guess
      } else {
        sqrtIt(improve(guess))
      }

    }

    sqrtIt(1)
  }

}
