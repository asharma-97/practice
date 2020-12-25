package codes.scala

object HeightChecker extends App {
  def heightChecker(heights: Array[Int]): Int = {
    heights.sorted.zip(heights).map(x => if (x._1 == x._2) 0 else 1).sum
  }
}
