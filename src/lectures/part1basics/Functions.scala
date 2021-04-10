package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 5))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(4))

  def exOneFunction(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " old."
  println(exOneFunction("João", 30))

  def exTwoFunction(num: Int): Int = {
    if (num == 1) 1
    else num * exTwoFunction(num - 1)
  }
  println(exTwoFunction(10))

  def exThreeFunction(num: Int): Int = {
    if (num == 1 || num == 2) 1
    else exThreeFunction(num - 1) + exThreeFunction(num - 2)
  }
  println(exThreeFunction(42))

  def exFourFunction(num: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(num / 2)
  }
  println(exFourFunction(1019))
  println(exFourFunction(37 * 17))
}
