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

public class SmallestMultiple
{
	public static void main(String[] args) {
        boolean smallestMultipleFound = false;
        long currentNum = 2520;

        while (!smallestMultipleFound) {
            if (isEvenlyDivisibleToTwenty(currentNum)) {
                smallestMultipleFound = true;
                System.out.println(currentNum);
            } else {
                currentNum += 20;
            }
        }
    }

    public static boolean isEvenlyDivisibleToTwenty(long num) {
       for (int i = 20; i >= 1; i--) {
            if (num % i != 0) {
                return false;
            }
        }
        return true; 
    }
}
