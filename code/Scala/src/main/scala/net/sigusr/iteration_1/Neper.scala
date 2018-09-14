package net.sigusr.iteration_1

object Neper {

  def bailOut(s: String): Nothing = {
    println(s)
    sys.exit(1)
  }

  def parseArgs(args: Array[String]): String =
    if (args.length != 1) bailOut("Not enough arguments") else args(0)

  def toDouble(s: String): Double =
    try {
      s.toDouble
    } catch {
      case _: Exception => bailOut("Arguments is not a Double")
    }

  def logarithm(d: Double): Double = {
    val l = scala.math.log(d)
    if (l != l || l == Double.NegativeInfinity)
      bailOut("Argument is not in the domain of logarithm")
    else l
  }

  def formatResult(d: Double, l: Double): String = s"Ln($d) = $l"

  def main(args: Array[String]): Unit = {
    val d = toDouble(parseArgs(args))
    println(formatResult(d, logarithm(d)))
  }
}
