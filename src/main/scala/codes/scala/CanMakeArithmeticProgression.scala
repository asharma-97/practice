package codes.scala

import scala.collection.mutable

object CanMakeArithmeticProgression extends App {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    val hs: mutable.HashSet[Int] = new mutable.HashSet[Int]()
    arr.foreach(hs.add)
    val n = arr.length
    if(n == 1) return true
    val min = arr.min
    val d = (arr.max - arr.min) / (n - 1)
    var ans = true
    for(i <- 0 until n) {
      ans = ans && hs.contains(min + i * d)
    }
    ans
  }
}
