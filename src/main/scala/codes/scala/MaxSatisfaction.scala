package codes.scala

object MaxSatisfaction extends App {
  def maxSatisfaction(satisfaction: Array[Int]): Int = {
    val sorted = satisfaction.sorted
    var total = 0
    var res = 0
    for (i <- (sorted.length - 1) to 0 by -1 if sorted(i) + total > 0) {
      total = total + sorted(i)
      res = res + total
    }
    res
  }
}
