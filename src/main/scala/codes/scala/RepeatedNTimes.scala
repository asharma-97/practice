package codes.scala

import scala.annotation.tailrec

object RepeatedNTimes extends App {
  def repeatedNTimes(A: Array[Int]): Int = {
    @tailrec
    def helper(l: List[Int], s: Set[Int]): Int = {
      l match {
        case head :: tail =>
          if(s.contains(head)) head
          else helper(tail, s + head)
        case Nil => 0
      }
    }
    helper(A.toList, Set())
  }
}
