package codes.scala

object DiStringMatch extends App {
  def diStringMatch(S: String): Array[Int] = {
    var h = S.length
    var l = 0
    (S.map {
      case 'I' =>
        val temp = l
        l += 1
        temp
      case 'D' =>
        val temp = h
        h -= 1
        temp
    }.toList ++ List(h)).toArray
  }
  diStringMatch("III").foreach(println)
}
