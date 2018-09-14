package net.sigusr.iteration_0

object Neper {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Not enough arguments")
      sys.exit(1)
    } else {
      try {
        val d = args(0).toDouble
        val l = scala.math.log(d)
        if (l != l || l == Double.NegativeInfinity) {
          println("Argument is not in the domain of logarithm")
          sys.exit(1)
        } else println(s"Ln($d) = $l")
      } catch {
        case _: Exception =>
          println("Arguments is not a Double")
          sys.exit(1)
      }
    }
  }
}
