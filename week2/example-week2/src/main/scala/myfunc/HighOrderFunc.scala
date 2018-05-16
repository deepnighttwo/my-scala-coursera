package myfunc

object HighOrderFunc {
  def main(args: Array[String]): Unit = {
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      f(a) + f(b)
    }

    def sum2(f: Int => Int): (Int, Int) => Int = {
      def innerSum(a: Int, b: Int): Int = {
        var sumret = 0
        for (i <- a to b) {
          sumret = sumret + f(i)
        }
        sumret
      }

      innerSum
    }

    def sum3(f: Int => Int)(a: Int, b: Int): Int = {
      var sumret = 0
      for (i <- a to b) {
        sumret = sumret + f(i)
      }
      sumret
    }

    def sumT1(f: Int => Int): (Int, Int) => (Int, Int) => Int = {
      def si1(a: Int, b: Int): (Int, Int) => Int = {
        def si2(c: Int, d: Int): Int = {
          c + d
        }

        si2
      }

      si1
    }


    def sumT2(f: Int => Int)(a: Int, b: Int)(c: Int, d: Int): Int = {
      9
    }
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > acc) 0
      else f(a) + loop(a + 1, acc)
    }

    loop(a, b)
  }


}
