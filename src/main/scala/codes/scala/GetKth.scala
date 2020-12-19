package codes.scala

import scala.collection.mutable

object GetKth extends App {
  def getKth(lo: Int, hi: Int, k: Int): Int = {
    val hm = new mutable.HashMap[Int, Int]()
    hm += ((1,0))
    def fun(x: Int): Int = {
      if (hm.contains(x)) hm(x)
      else {
        val a = 1 + (if (x % 2 == 0) fun(x / 2) else fun(3 * x + 1))
        hm += ((x,a))
        a
      }
    }

    val list = (lo to hi).zipWithIndex.map(t => (fun(t._1), t._2)).sortBy(t => t._1)
    list(k - 1)._2 + lo
  }
  println(getKth(1, 1000, 777))
}
