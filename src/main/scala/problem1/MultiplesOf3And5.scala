/**
* @author Claire Jaja
* @version 10/30/14
*
* Project Euler Problem 1
* Multiples of 3 and 5
* If we list all the natural numbers below 10
* that are multiples of 3 or 5, we get 3, 5, 6, and 9.
* The sum of these multiples is 23.
* Find the sum of all the multiples of 3 or 5 below 1000.
*/

object MultiplesOf3And5 {
  // integer to calculate multiples to
  val num = 1000

  def main(args: Array[String]) {
    var sum = 0
    for (i <- 3 until num) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i
      }
    }
    println(sum)
  }
}
