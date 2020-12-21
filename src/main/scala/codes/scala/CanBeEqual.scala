package codes.scala

object CanBeEqual extends App {
  def canBeEqual(target: Array[Int], arr: Array[Int]): Boolean = {
    if (target.length > arr.length) return false
    val mem = new Array[Int](1001)
    target.foreach(x => mem(x) += 1)
    arr.foreach { x =>
      if (mem(x) == 0) return false
      else mem(x) -= 1
    }
    true
  }
}
