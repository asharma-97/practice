package codes.scala

object MaxDepthAfterSplit extends App {
  def maxDepthAfterSplit(seq: String): Array[Int] = {
    val res: Array[Int] = new Array[Int](seq.length)
    var a = 0
    var b = 0
    for (c <- seq.zipWithIndex) {
      c._1 match {
        case '(' =>
          if (a < b) a += 1
          else {
            b += 1
            res(c._2) = 1
          }
        case ')' =>
          if (a > b) a -= 1
          else {
            b -= 1
            res(c._2) = 1
          }
      }
    }
    res
  }
  maxDepthAfterSplit("(()())").foreach(print + " ")
}
