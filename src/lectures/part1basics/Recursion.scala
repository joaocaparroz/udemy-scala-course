package lectures.part1basics

import sun.font.TrueTypeFont

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  println(anotherFactorial(5000))

  def strConcat(string: String, times: Int): String = {
    @tailrec
    def strHelper(string: String, times: Int, acc: String): String =
      if (times <= 0) acc
      else strHelper(string, times - 1, string + acc)

    strHelper(string, times, "")
  }

  println(strConcat("Olar", 2))

  def isPrime(x: Int): Boolean = {
    @tailrec
    def primeHelper(acc: Boolean, divisor: Int): Boolean = {
      if (divisor <= 1 || !acc) acc
      else primeHelper((x % divisor != 0) && acc, divisor - 1)
    }

    primeHelper(acc = true, x - 1)
  }

  println(isPrime(1019))
  println(isPrime(1024))

  def fibonacci(x: Int): Int = {
    @tailrec
    def fibonacciHelper(x: Int, acc: Int, acc2: Int, count: Int): Int =
      if (count == x) acc + acc2
      else fibonacciHelper(x, acc2, acc + acc2, count + 1)

    if (x == 0) 0
    else if (x == 1) 1
    else fibonacciHelper(x, 0, 1, 2)
  }

  println(fibonacci(29))
}
