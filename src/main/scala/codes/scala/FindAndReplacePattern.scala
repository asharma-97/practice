package codes.scala

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object FindAndReplacePattern extends App {
  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
    def numeric(s: String): Array[Int] = {
      val arr = new Array[Int](s.length)
      var counter = 0
      val hs = new mutable.HashMap[Char, Int]()
      for(i <- s.indices) {
        if(hs.contains(s.charAt(i))) {
          arr(i) = hs(s.charAt(i))
        } else {
          hs += ((s.charAt(i), counter))
          arr(i) = counter
          counter += 1
        }
      }
      arr
    }
    val n1 = numeric(pattern)
    val lb = new ListBuffer[String]
    words.foreach { word =>
      if (numeric(word).sameElements(n1)) lb += word
    }
    lb.toList
  }
  findAndReplacePattern(List("abc","deq","mee","aqq","dkd","ccc").toArray, "abb").foreach(println)
}
