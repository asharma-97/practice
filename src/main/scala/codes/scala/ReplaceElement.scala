package codes.scala

object ReplaceElement extends App {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    val r = arr.reverse
    var max = Integer.MIN_VALUE
    for (i <- r.indices) {
      val temp = r(i)
      r(i) = max
      max = Math.max(temp, max)
    }
    if (r.length == 0) arr
    else {
      r(0) = -1
      r.reverse
    }
  }
  replaceElements(List(17,18,5,4,6,1).toArray).foreach(print)
}
