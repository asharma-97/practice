package codes.scala

object MinSubsequence extends App {
  def minSubsequence(nums: Array[Int]): List[Int] = {
    val total = nums.sum
    def recur(xs: List[Int], sum: Int): List[Int] = {
      xs match {
        case head :: tail =>
          if(sum + head > (total- sum - head)) List(head)
          else head :: recur(tail, sum + head)
        case Nil => List()
      }
    }
    recur(nums.sorted.toList.reverse, 0)
  }
  minSubsequence(List(4,4,7,6,7).toArray).foreach(print)
}
