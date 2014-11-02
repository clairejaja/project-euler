/**
* @author Claire Jaja
* @version 11/1/14
*
* Project Euler
* Problem 4
* Largest palindrome product
*
* A palindromic number reads the same both ways.
* The largest palindrome made from the product of two 2-digit numbers
* is 9009 = 91 X 99
* Find the largest palindrome made from the product of two 3-digit numbers.
*/

object LargestPalindromeProduct {

  def main(args: Array[String]) {
    var largestProduct = 0
    // multiply all 3-digit numbers
    for (i <- 999 to 100 by -1) {
      for (j <- i to 100 by -1) {
        // check each product, if is palindrome, store
        var product = i * j
        if (product.toString == product.toString.reverse && product > largestProduct) {
          largestProduct = product
        }
      }
    }
    println(largestProduct)
  }
}
