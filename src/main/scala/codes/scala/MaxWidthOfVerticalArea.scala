package codes.scala

object MaxWidthOfVerticalArea extends App {
  def maxWidthOfVerticalArea(points: Array[Array[Int]]): Int = {
    val sortedArray = points.map(_.head).sorted
    if(sortedArray.isEmpty) 0
    else sortedArray.foldLeft((sortedArray.head ,0))((a, b) => (b, Math.max(a._2, Math.abs(a._1 - b))))._2
  }
}
