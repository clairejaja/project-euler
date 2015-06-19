/**
* @author Claire Jaja
* @version 11/4/14
*
* Project Euler
* Problem 5
* Smallest multiple
*
* 2520 is the smallest number that can be divided by each of the numbers
* from 1 to 10 without any remainder.
* What is the smallest positive number that is evenly divisible
* by all the numbers from 1 to 20?
*/

object SmallestMultiple {

  def main(args: Array[String]) {
    var smallestMultipleFound = false
    var currentNum = 2520
    while (!smallestMultipleFound) {
      if (isEvenlyDivisibleToTwenty(currentNum)) {
        smallestMultipleFound = true
        println(currentNum)
      }
      else currentNum += 20
    }
  }

  def isEvenlyDivisibleToTwenty(x:Int):Boolean = {
    for (i <- 20 to 1 by -1) {
      //println(x+"/"+i)
      if (x % i != 0) return false
    }
    return true
  }
}
