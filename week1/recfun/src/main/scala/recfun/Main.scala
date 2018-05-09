package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0 || c > r) {
      0
    } else if (c == r) {
      1
    } else {
      pascal(c, r - 1) + pascal(c - 1, r - 1)
    }

  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def reduceNum(a: Int, b: Int): Int = {
      if (a >= 0) {
        a + b
      } else {
        -1
      }
    }

    chars.filter(ch => ch == '(' || ch == ')').map {
      case '(' => 1
      case ')' => -1
    }.reduceLeft(reduceNum) == 0
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
