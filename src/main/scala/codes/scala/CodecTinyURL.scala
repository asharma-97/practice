package codes.scala

import scala.collection.mutable
import scala.util.Random

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = new Codec()
 * val s = obj.encode(longURL)
 * val ans = obj.decode(s)
 */

object CodecTinyURL extends App {

  class Codec {
    val random = new Random()
    val hm = new mutable.HashMap[String, String]()
    val hs = new mutable.HashSet[String]()
    def encode(longURL: String): String = {
      var s = random.nextString(6)
      while(hs.contains(s)) {
        s = random.nextString(6)
      }
      hs.add(s)
      hm += ((s, longURL))
      s
    }

    def decode(shortURL: String): String = {
      hm.getOrElse(shortURL, "")
    }
  }

}
