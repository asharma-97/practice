package codes.scala

object SelfDividingNumbers extends App {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    def isSelfDividing(num: Int): Boolean = {
      num.toString.forall(x => (x.toInt - 48) != 0 && num % (x.toInt - 48) == 0)
    }

    (left to right).map(x => Some(x).filter(isSelfDividing)).toList.flatten
  }

  selfDividingNumbers(1, 22).foreach(println)
}
