package codes.scala

object FreqAlphabets extends App {
  println(freqAlphabets("10#11#12"))
  def freqAlphabets(s: String): String = {
    val m1: List[(String, Char)] = (1 to 9).map(x => (s"$x", (x+96).toChar)).toList
    val m2: List[(String, Char)] = (10 to 26).map(x => (s"$x#" ,(x+96).toChar)).toList
    m1.foldLeft[String](m2.foldLeft[String](s)((x, y) => x.replace(y._1, y._2.toString)))((x, y) => x.replace(y._1, y._2.toString))
  }
}
