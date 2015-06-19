/**
* @author Claire Jaja
* @version 11/4/14
*
* Project Euler
* Problem 6
* Sum square difference
*
* The sum of the squares of the first ten natural numbers is:
* 1^2 + 2^2 + ... + 10^2 = 385
* The square of the sum of the first ten natural numbers is:
* (1 + 2 + ... + 10)^2 = 55^2 = 3025
* Hence the difference between the sum of the squares of the first ten natural
* numbers and the square of the sum is 3025 - 385 = 2640
* Find the difference between the sum of the squares of the first one hundred
* natural numbers and the square of the sum.
*/

object SumSquareDifference {
  def main(args: Array[String]) {
    // to calculate to
    val num = 100

    def squareOfSum(x:Int):Int = {val sum = Range(1,x+1).sum; sum*sum}
    def sumOfSquares(x:Int):Int = Range(1,x+1).map(i => i*i).sum
    def difference(f: Int => Int, g: Int => Int, x: Int):Int = f(x) - g(x)

    println(difference(squareOfSum,sumOfSquares,num))
  }
}
