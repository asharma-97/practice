package codes.scala

import scala.annotation.tailrec

object UniqueOccurrences extends App {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    @tailrec
    def helper(l: List[Int], hm: Map[Int, Int]): Boolean = {
      l match {
        case head :: tail => helper(tail, hm + (head -> (hm.getOrElse(head, 0) + 1)))
        case Nil =>
          hm.values.size == hm.values.toSet.size
      }
    }
    helper(arr.toList, Map())
  }
}
