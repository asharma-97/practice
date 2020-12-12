package codes.scala

import scala.collection.mutable.ListBuffer

object IntervalIntersection extends App {
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val first = A.map(x => (x.head, x.last))
    val second = B.map(x => (x.head, x.last))
    val lb: ListBuffer[Array[Int]] = new ListBuffer[Array[Int]]()
    var i = 0
    var j = 0
    while (i < A.length && j < B.length) {
      mainStuff(first, i, second, j)
      if (first(i)._2 > second(j)._2) {
        j += 1
      } else if (first(i)._2 < second(j)._2) {
        i += 1
      } else {
        i += 1
        j += 1
      }
    }

    def mainStuff(first: Array[(Int, Int)], i: Int, second: Array[(Int, Int)], j: Int): Unit = {
      if (first(i)._2 >= second(j)._1 && first(i)._1 <= second(j)._1) {
        lb += Array(second(j)._1, Math.min(first(i)._2, second(j)._2))
      } else if (second(j)._2 >= first(i)._1 && second(j)._1 <= first(i)._1) {
        lb += Array(first(i)._1, Math.min(first(i)._2, second(j)._2))
      }
    }

    lb.toArray
  }

  val x = intervalIntersection(Array((0, 2), (5, 10), (13, 23), (24, 25)).map(x => Array(x._1, x._2)),
    Array((1, 5), (8, 12), (15, 24), (25, 26)).map(x => Array(x._1, x._2)))
  x
}
