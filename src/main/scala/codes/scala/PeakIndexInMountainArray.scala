package codes.scala

import scala.annotation.tailrec

object PeakIndexInMountainArray extends App {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    @tailrec
    def fun(arr: Array[Int], f: Int, l: Int): Int = {
      val m = (f + l) / 2
      if (arr(m - 1) < arr(m) && arr(m + 1) < arr(m)) m
      else if (arr(m + 1) > arr(m)) fun(arr, m + 1, l)
      else fun(arr, f, m)
    }

    fun(arr, 0, arr.length - 1)
  }

  println(peakIndexInMountainArray(List(3, 5, 3, 2, 0).toArray))
}
