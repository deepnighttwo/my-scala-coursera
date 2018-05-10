package funfunc

import scala.collection.mutable
import scala.io.Source

object CheckNetStatus {
  def main(args: Array[String]): Unit = {

    val colos = mutable.HashMap.empty[String, Int]
    val hosts = mutable.HashMap.empty[String, Int]

    val keyWrod = "risktxncomputeserv"

    Source.fromFile("D:\\net.txt").getLines.foreach(line => {
      if (line.contains(keyWrod)) {
        val dotIndex = line.indexOf('.', line.indexOf(keyWrod)) + 1
        val colo = line.substring(dotIndex, line.indexOf('.', dotIndex))
        val hostname = line.substring(56, line.indexOf('.', 58))

        colos.update(colo, colos.getOrElse(colo, 0) + 1)

        hosts.update(hostname, hosts.getOrElse(colo, 0) + 1)

      }
    })

    colos.foreach {
      case (movie, rating) => println(s"key: $movie, value: $rating")
    }

    hosts.foreach {
      case (movie, rating) => println(s"key: $movie, value: $rating")
    }
  }

}
