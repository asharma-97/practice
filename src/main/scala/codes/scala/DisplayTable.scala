//package codes.scala
//
//import scala.collection.mutable
//import scala.collection.mutable.ListBuffer
//
//object DisplayTable extends App {
//  def displayTable(orders: List[List[String]]): List[List[String]] = {
//    val ts = new mutable.TreeSet[String]()
//    val tm = new mutable.TreeMap[Int, mutable.TreeMap[String, Int]]()
//    orders.foreach { x =>
//      if(tm.contains(x(1).toInt)) {
//        tm(x(1).toInt).update(x(2), tm(x(1).toInt).getOrElse(x(2), 0) + 1)
//      } else {
//        tm += ((x(1).toInt, new mutable.TreeMap[String, Int]() + (x(2), 1)))
//      }
//    }
//    tm.foreach(x => x._2.keys.foreach(ts.addOne))
//    val l: List[List[String]] = tm.map { x =>
//      val lb = new ListBuffer[String]
//      lb.addOne(x._1.toString)
//      ts.foreach(y => lb.addOne(x._2.getOrElse(y, 0).toString))
//      lb.toList
//    }.toList
//    val x = ("Table" :: ts.toList) :: l
//    x
//  }
//  displayTable(List(List("David","3","Ceviche"), List("Corina","10","Beef Burrito"), List("David","3","Fried Chicken"),
//    List("Carla","5","Water"), List("Carla","5","Ceviche"), List("Rous","3","Ceviche")))
//}
