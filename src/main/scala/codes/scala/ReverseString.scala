package codes.scala

object ReverseString extends App {
  def reverseString(s: Array[Char]): Unit = {
    var i = 0
    var j = s.length - 1
    for(x <- i to j) {
      if(i <= j) {
        swap(s, i, j)
        i += 1
        j -= 1
      }
    }
  }
  def swap(s: Array[Char], i: Int, j: Int): Unit = {
    val temp = s(i)
    s(i) = s(j)
    s(j) = temp
  }
}
