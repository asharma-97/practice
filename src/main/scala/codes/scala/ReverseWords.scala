package codes.scala

object ReverseWords extends App {
  def reverseWords(s: String): String = {
    s.split(' ').map(_.reverse).reduce(_ + " " + _)
  }
}
