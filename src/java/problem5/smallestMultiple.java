import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 1/13/14
*
* Project Euler Problem 5
* Smallest multiple
* 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
* What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

public class smallestMultiple
{
	public static void main(String[] args) {
        boolean smallestMultipleFound = false;
        long currentNumber = 20;

        while (!smallestMultipleFound) {
            if (isEvenlyDivisibleByAllNumbersToTwenty(currentNumber)) {
                smallestMultipleFound = true;
                System.out.println(currentNumber);
            } else {
                currentNumber++;
            }
        }
    }

    public static boolean isEvenlyDivisibleByAllNumbersToTwenty(long num) {
       for (int i = 20; i >= 1; i--) {
            if (num % i != 0) {
                return false;
            }
        }
        return true; 
    }
}
