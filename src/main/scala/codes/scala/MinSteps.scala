package codes.scala

object MinSteps extends App {
  def minSteps(s: String, t: String): Int = {
    val m1 = t.foldLeft(Map[Char, Int]())((a,b) => a + (b -> (a.getOrElse(b, 0) + 1)))
    val m2 = s.foldLeft(Map[Char, Int]())((a,b) => a + (b -> (a.getOrElse(b, 0) + 1)))
    m2.foldLeft(0)((a,b) => a + {
      if(b._2 > m1.getOrElse(b._1, 0)) Math.abs(b._2 - m1.getOrElse(b._1, 0))
      else 0
    })
  }
  println(minSteps("leetcode", "practice"))
}
