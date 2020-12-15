package codes.scala

import scala.collection.mutable

object FinalPrices extends App {
  def finalPrices(prices: Array[Int]): Array[Int] = {
    val s: mutable.Stack[Int] = new mutable.Stack[Int]()
    for (i <- prices.indices) {
      while (s.nonEmpty && prices(s.top) >= prices(i)) {
        prices(s.pop()) -= prices(i)
      }
      s.push(i)
    }
    prices
  }

  finalPrices(List(8, 4, 6, 2, 3).toArray).foreach(print)
}
