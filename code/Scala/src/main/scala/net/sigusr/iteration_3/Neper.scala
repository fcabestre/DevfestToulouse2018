package net.sigusr.iteration_3

sealed trait Result[+V] {
  def link[W](f: V => Result[W]): Result[W] = this match {
    case Success(v) => f(v)
    case Error(e)   => Error(e)
  }

  def linkAndWrap[W](f: V => W): Result[W] = this match {
    case Success(v) => Success(f(v))
    case Error(e)   => Error(e)
  }

  def finish[W](f: BailOut => W, g: V => W): W = this match {
    case Success(v) => g(v)
    case Error(e)   => f(e)
  }
}
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
    val r = parseArgs(args).link(
      s =>
        toDouble(s).link(
          d =>
            logarithm(d).linkAndWrap(
              l => formatResult(d, l)
          )
      )
    )
    r.finish(_.run(), println)
  }
}
