package codes.scala

object KWeakestRows extends App {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    def getNumberOfOnes(arr: Array[Int]): Int = {
      val n: Int = arr.length
      var l = 0
      var r = n
      while(l < r) {
        val mid = (l+r)/2
        if(arr(mid) == 1)
          l = mid + 1
        else
          r = mid
      }
      l
    }
    mat.map(getNumberOfOnes).zipWithIndex.sortBy(a => a._1).take(k).map(_._2)
  }
}
