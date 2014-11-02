/**
* @author Claire Jaja
* @version 10/30/14
*
* Project Euler
* Problem 3
* Largest prime factor
*
* The prime factors of 13195 are 5, 7, 13, and 29.
* What is the largest prime factor of the number 600851475143?
*/
import math._
import scala.collection.mutable

object LargestPrimeFactor {
  val num = 600851475143L
  //val num = 13195

  def main(args: Array[String]) {
    // calculate all primes up to square root of num
    var primes = calcPrimes(sqrt(num.toDouble).ceil.toInt)
    var largestPrimeFactor = 0
    var i = primes.size - 1

    for (prime <- primes) {
      if (num % prime == 0 && prime > largestPrimeFactor) largestPrimeFactor = prime
    }

    println(largestPrimeFactor)
  }

  // calculate all primes up to x using sieve of Eratosthenes
  def calcPrimes(x: Int): List[Int] = {
    var isPrime = mutable.Map((for (i <- 3 to x by 2) yield (i -> true)):_*)
    for (i <- 3 to sqrt(x.toDouble).ceil.toInt by 2) {
      if (isPrime(i)) {
        for (j <- i to x/i by 2) {
          isPrime(i*j) = false
        }
      }
    }
    
    return isPrime.filter({case (num,bool) => bool}).map({case (num,bool) => num}).toList
  }
}
