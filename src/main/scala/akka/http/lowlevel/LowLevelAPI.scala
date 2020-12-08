package akka.http.lowlevel

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.IncomingConnection
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}

import scala.concurrent.Future

object LowLevelAPI extends App {
  implicit val system = ActorSystem("system")
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val serverSource: Source[Http.IncomingConnection, Future[Http.ServerBinding]] = Http() newServerAt("localhost", 3000) connectionSource()
  val connectionSink = Sink.foreach[IncomingConnection] { connection =>
    println(s"Accepted incoming conenction from: ${connection.remoteAddress}")
  }
}
