package codes.scala

import scala.collection.mutable

object DeckRevealedIncreasing extends App {
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] = {
    val sorted = deck.sorted
    val q: mutable.Queue[Int] = new mutable.Queue[Int]()
    for (i <- sorted.indices) {
      q += i
    }
    val ans: Array[Int] = new Array[Int](sorted.length)
    for (i <- sorted.indices) {
      ans(q.dequeue()) = sorted(i)
      if(q.nonEmpty)
        q.enqueue(q.dequeue())
    }
    ans
  }
  deckRevealedIncreasing(List(17,13,11,2,3,5,7).toArray)
}
