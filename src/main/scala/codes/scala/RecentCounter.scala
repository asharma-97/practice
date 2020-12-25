package codes.scala

import scala.collection.mutable

class RecentCounter() {
  val queue = new mutable.Queue[Int]()
  var counter = 0

  def ping(t: Int): Int = {
    queue.enqueue(t)
    counter += 1
    while (t - queue.front > 3000) {
      queue.dequeue()
      counter -= 1
    }
    counter
  }
}
