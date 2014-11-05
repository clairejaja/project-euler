/**
* @author Claire Jaja
* @version 9/11/14
*
* Project Euler Problem 6
* Sum square difference
* The sum of the squares of the first ten natural numbers is:
* 1^2 + 2^2 + ... + 10^2 = 385
* The square of the sum of the first ten natural numbers is:
* (1 + 2 + ... + 10)^2 = 55^2 = 3025
* Hence the difference between the sum of the squares of the first ten natural
* numbers and the square of the sum is 3025 - 385 = 2640
* Find the difference between the sum of the squares of the first one hundred
* natural numbers and the square of the sum.
*/

public class SumSquareDifference {
    // integer to calculate to
    private static int num = 100;

    public static void main(String[] args) {
        double sum = 0;
        double sumOfSquares = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
            sumOfSquares += i*i;
        }
        double squareOfSum = sum*sum;

        // find the difference
        double difference = squareOfSum - sumOfSquares;
        System.out.printf("%.0f",difference);
        System.out.println();
    }
}
