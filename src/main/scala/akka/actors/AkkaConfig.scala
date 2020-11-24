package akka.actors

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object AkkaConfig extends App {
  /**
   * 1. Inline configuration
   * */
  val configString =
    """
      | akka {
      |   loglevel = "ERROR"
      | }
      |""".stripMargin
  val system = ActorSystem("system", ConfigFactory.load(ConfigFactory.parseString(configString)))

  class SimpleLoggingActor extends Actor with ActorLogging {
    override def receive: Receive = {
      case message => log.info(message.toString)
    }
  }
  val actor = system.actorOf(Props[SimpleLoggingActor])
  actor ! "Log it"

  /**
   * 2. From file
   * */

  val defaultConfigFileSystem = ActorSystem("defaultconfigfilesystem")
  val defaultConfigActor = defaultConfigFileSystem.actorOf(Props[SimpleLoggingActor])
  defaultConfigActor ! "Log it"

  /**
   * 3. Separate configuration in same file for separate actorSystems
   * */
  val specialConfig = ConfigFactory.load().getConfig("mySpecialConfig")
  println(s"special config: ${specialConfig.getString("akka.loglevel")}")

  /**
   * 4. In separate files
   * */
  val separateConfig = ConfigFactory.load("secretFolder/secretConfiguration.conf")
  println(s"separate config: ${separateConfig.getString("akka.loglevel")}")

  /**
   * 5. Different file formats
   * */
  val jsonConfig = ConfigFactory.load("json/jsonConfig.json")
  println(s"json config: ${jsonConfig.getString("akka.loglevel")}")
}
