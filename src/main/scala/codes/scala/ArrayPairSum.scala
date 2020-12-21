package codes.scala

object ArrayPairSum extends App {
  def arrayPairSum(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var sum = 0
    for (i <- 0 until nums.length / 2) {
      sum += Math.min(sorted(2 * i), sorted(2 * i + 1))
    }
    sum
  }
  arrayPairSum(Array(1, 4, 3, 2))
}
