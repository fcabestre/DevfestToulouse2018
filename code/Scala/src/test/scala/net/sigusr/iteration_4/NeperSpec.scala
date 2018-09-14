package net.sigusr.iteration_4

import org.scalatest.FlatSpec

class NeperSpec extends FlatSpec {

  "Neper.logarithm" should "not be defined for x = 0" in {
    assert(
      Neper.logarithm(0) == Error(
        BailOut("Argument is not in the domain of logarithm")))
  }
  it should "not be defined for x < 0" in {
    assert(
      Neper.logarithm(-1) == Error(
        BailOut("Argument is not in the domain of logarithm")))
  }
  it should "be defined for x > 0" in {
    assert(Neper.logarithm(1) == Success(0.0))
  }

  "Neper.parseArgs" should "succeed when there is exactly one argument" in {
    assert(Neper.parseArgs(Array("Yeah")) == Success("Yeah"))
  }
  it should "fail when there is more than one argument" in {
    assert(
      Neper.parseArgs(Array("Meh", "Yolo")) == Error(
        BailOut("Not enough arguments")))
  }
  it should "fail when there is no arguments" in {
    assert(Neper.parseArgs(Array()) == Error(BailOut("Not enough arguments")))
  }

  "Neper.toDouble" should "succeed for a string representing a Double" in {
    assert(Neper.toDouble("-1.23e10") == Success(-1.23e10))
  }
  it should "fail for any other string" in {
    assert(Neper.toDouble("Meh") == Error(BailOut("Arguments is not a Double")))
  }

  "Neper.formatResult()" should "provide the corectly formatted result " in {
    assert(Neper.formatResult(1.0, 0.0) == "Ln(1.0) = 0.0")
  }
}
