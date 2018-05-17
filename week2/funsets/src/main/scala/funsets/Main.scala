package funsets

object Main extends App {
  import FunSets._
//  println(contains(singletonSet(1), 1))


  val origin = List(1, 3, 4, 5, 7, 1000)
  val s: Int => Boolean = origin.contains(_)
  FunSets.printSet(map(s, x => x - 1))

}
