
val myset = new EmptySet().incl(1).incl(2).incl(3)
val myset2 = new EmptySet().incl(4).incl(5).incl(6)
myset.contains(1)
myset.contains(2)
myset.contains(3)
myset.contains(4)
myset.contains(5)

myset.union(myset2)

val list = new Con[Int](999, new Con[Int](888, new Con[Int](777, new Nil[Int])))

list nth 3

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(set: IntSet): IntSet
}

class NonEmpty(val left: IntSet, val elem: Int, val right: IntSet) extends IntSet {

  override def incl(x: Int): IntSet = {
    if (x == elem) this
    else if (x > elem) new NonEmpty(left, elem, right.incl(x))
    else new NonEmpty(left.incl(x), elem, right)
  }

  override def contains(x: Int): Boolean = {
    if (elem == x) true
    else if (x > elem) right.contains(x)
    else left.contains(x)
  }

  override def toString: String = "{" + left + elem + right + "}"

  override def union(set: IntSet) = left union right union set incl elem
}

class EmptySet extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(new EmptySet, x, new EmptySet)

  override def contains(x: Int): Boolean = false

  override def toString: String = "."

  override def union(set: IntSet) = set
}

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def nth(x: Int): T
}

class Nil[T] extends List[T] {
  override def isEmpty = true

  override def head = throw new NoSuchElementException("Nil.head")

  override def tail = throw new NoSuchElementException("Nil.tail")

  override def nth(x: Int) = throw new IndexOutOfBoundsException("Nil")
}

class Con[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty = false

  override def nth(x: Int) = {
    if (x == 0) head
    else tail.nth(x - 1)
  }
}












