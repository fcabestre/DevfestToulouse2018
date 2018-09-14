package net.sigusr.iteration_5

sealed case class BailOut(s: String) {
  def run(): Nothing = {
    println(s)
    sys.exit(1)
  }
}

object Neper {

  type Result[V] = Either[BailOut, V]

  def parseArgs(args: Array[String]): Result[String] =
    if (args.length != 1) Left(BailOut("Not enough arguments"))
    else Right(args(0))

  def toDouble(s: String): Result[Double] =
    try {
      Right(s.toDouble)
    } catch {
      case _: Exception => Left(BailOut("Arguments is not a Double"))
    }

  def logarithm(d: Double): Result[Double] = {
    val l = scala.math.log(d)
    if (l != l || l == Double.NegativeInfinity)
      Left(BailOut("Argument is not in the domain of logarithm"))
    else Right(l)
  }

  def formatResult(d: Double, l: Double): String = s"Ln($d) = $l"

  def main(args: Array[String]): Unit = {
    val r = for {
      a <- parseArgs(args)
      d <- toDouble(a)
      l <- logarithm(d)
    } yield formatResult(d, l)
    r.fold(_.run(), println)
  }
}
