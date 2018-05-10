package funfunc

object TailRecursiveFactorial {

  def main(args: Array[String]): Unit = {
    println(factorial(4))
  }

  def factorial(x: Int): Int = {
    def factorialItor(prev: Int, x: Int): Int = {
      if (x == 0) {
        prev
      } else {
        factorialItor(x * prev, x - 1)
      }
    }

    factorialItor(1, x)
  }


}
