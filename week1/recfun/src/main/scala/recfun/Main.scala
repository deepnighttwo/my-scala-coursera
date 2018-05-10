package recfun

import scala.collection.immutable

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

    println(countChange(4, List(1, 2)))
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
    def balanceIt(left: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) {
        left == 0
      } else {
        if (chars.head == '(') {
          balanceIt(left + 1, chars.tail)
        } else {
          if (left == 0) {
            false
          } else {
            balanceIt(left - 1, chars.tail)
          }
        }
      }
    }

    balanceIt(0, chars.filter(ch => ch == '(' || ch == ')'))

  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    val maxParams = coins.map(money / _)
    val maxParamsRev = coins.map(money / _).reverse

    def nextParam(param: List[Int]) = {
      var delta = -1
      val p = for (
        pair <- param.reverse.zip(maxParamsRev)
      ) yield {
        val i = pair._1
        val max = pair._2
        if (delta == 0) {
          i
        } else {
          val v = i + delta
          delta = 0
          if (v < 0) {
            delta = -1
            max
          } else {
            v
          }
        }
      }
      if (p.head < 0 || delta == -1) {
        Nil
      } else {
        val real = p.reverse
        real
      }
    }

    def countChangeIt(total: Int, params: List[Int]): Int = {
      if (params == Nil) {
        total
      } else {
        val v = coins.zip(params).map { case (a, b) => a * b }.sum
        val newParam = nextParam(params)
        if (v == money) {
          countChangeIt(total + 1, newParam)
        } else {
          countChangeIt(total, newParam)
        }
      }
    }

    countChangeIt(0, maxParams)
  }
}
