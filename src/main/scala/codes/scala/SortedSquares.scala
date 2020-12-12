package codes.scala

object SortedSquares extends App {
  def sortedSquares(nums: Array[Int]): Array[Int] = {
//    nums.map(x => x*x).sorted
    val res = new Array[Int](nums.length)
    var i = 0
    var j = nums.length - 1
    for(x <- j to i by -1) {
        if(Math.abs(nums(i)) > Math.abs(nums(j))) {
          res(x) = nums(i) * nums(i)
          i += 1
        } else {
          res(x) = nums(j) * nums(j)
          j -= 1
        }
      }
    res
  }
  sortedSquares(Array(-4,-1,0,3,10))
}
