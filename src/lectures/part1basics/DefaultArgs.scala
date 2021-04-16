package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10)

  def savePicture(format: String = "jpg", width: Int = 1024, height: Int = 768): Unit = println("Saving Picture")
  savePicture(width = 800)

  savePicture(height = 600, width = 800, format = "bmp")

}
