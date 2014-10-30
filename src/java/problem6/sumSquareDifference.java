import java.util.*; // for ArrayList

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

public class sumSquareDifference
{
    public static void main(String[] args) {
        // first command line argument is integer to calculate to
        int num = 0;
        if (args.length > 0) {
            try {
                num = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        // find the square of the sum
        double sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        double squareOfSum = Math.pow(sum, 2);
        System.out.print("Square of sum is: ");
        System.out.printf("%.0f",squareOfSum);
        System.out.println();

        // find the sum of the squares
        double sumOfSquares = 0;
        for (int i = 1; i <= num; i++) {
            double square = Math.pow(i, 2);
            sumOfSquares += square;
        }
        System.out.print("Sum of squares is: ");
        System.out.printf("%.0f",sumOfSquares);
        System.out.println();

        // find the difference
        double difference = squareOfSum - sumOfSquares;
        System.out.print("The difference between the two is: ");
        System.out.printf("%.0f",difference);
        System.out.println();
    }
}
