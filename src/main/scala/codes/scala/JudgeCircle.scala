package codes.scala

object JudgeCircle extends App {
  def charToInt(c: Char): Int = c match {
    case c if c == 'R' || c == 'U' => 1
    case _ => -1
  }

  def judgeCircle(moves: String): Boolean = {
    moves.foldLeft((0, 0))((a, b) => if (b == 'R' || b == 'L') (a._1 + charToInt(b), a._2) else (a._1, a._2 + charToInt(b))) match {
      case (0, 0) => true
      case _ => false
    }
  }
  println(judgeCircle("LRUD"))
}
