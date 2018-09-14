package net.sigusr.iteration_2

sealed trait Result[+V]
case class Success[+V](v: V) extends Result[V]
case class Error(e: BailOut) extends Result[Nothing]

sealed case class BailOut(s: String) {
  def run(): Nothing = {
    println(s)
    sys.exit(1)
  }
}

object Neper {

  def parseArgs(args: Array[String]): Result[String] =
    if (args.length != 1) Error(BailOut("Not enough arguments"))
    else Success(args(0))

  def toDouble(s: String): Result[Double] =
    try {
      Success(s.toDouble)
    } catch {
      case _: Exception => Error(BailOut("Arguments is not a Double"))
    }

  def logarithm(d: Double): Result[Double] = {
    val l = scala.math.log(d)
    if (l != l || l == Double.NegativeInfinity)
      Error(BailOut("Argument is not in the domain of logarithm"))
    else Success(l)
  }

  def formatResult(d: Double, l: Double): String = s"Ln($d) = $l"

  def main(args: Array[String]): Unit = {
    val r = parseArgs(args) match {
      case Success(a) =>
        toDouble(a) match {
          case Success(d) =>
            logarithm(d) match {
              case Success(l) => Success(formatResult(d, l))
              case e          => e
            }
          case e => e
        }
      case e => e
    }
    r match {
      case Success(f) => println(f)
      case Error(e)   => e.run()
    }
  }
}
