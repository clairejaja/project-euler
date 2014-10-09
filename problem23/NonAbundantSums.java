import java.util.*; // for ArrayList
import java.math.*;
import java.io.*;

/**
* @author Claire Jaja
* @version 9/28/14
*
* Project Euler Problem 23
* A perfect number is a number for which the sum of its proper divisors
* is exactly equal to the number. For example, the sum of the 
* proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
* which means that 28 is a perfect number.
*
* A number n is called deficient if the sum of its proper divisors
* is less than n, and it is called abundant
* if this sum exceeds n.
*
* As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
* the smallest number that can be written as the sum
* of two abundant numbers is 24. By mathematical analysis, it can be shown
* that all integers greater than 28123 can be written as the sum
* of two abundant numbers.
* However, this upper limit cannot be reduced any further by analysis
* even though it is known that the greatest number that cannot be expressed
* as the sum of two abundant numbers is less than this limit.
*
* Find the sum of all the positive integers which cannot be written
* as the sum of two abundant numbers.
*/

public class NonAbundantSums {
    private static int num = 28123;
    public static void main(String[] args) {
        // find all abundant numbers up to 28123-12
        System.err.println("Finding abundant numbers...");
        ArrayList<Integer> abundantNumbers = calculateAbundantNumbersTo(num-12);

        // calculate all sums of abundant numbers
        // not very efficient, probably better way of doing this
        System.err.println("Finding abundant number sums...");
        ArrayList<Integer> abundantNumberSums = new ArrayList<Integer>();
        for (int i = 0; i < abundantNumbers.size(); i++) {
            int numOne = abundantNumbers.get(i);
            int j = i;
            int numTwo = abundantNumbers.get(j);
            int sum = numOne+numTwo;
            while (sum <= 28123 && j < abundantNumbers.size()) {
                abundantNumberSums.add(sum);
                j++;
                if (j != abundantNumbers.size()) {
                    numTwo = abundantNumbers.get(j);
                    sum = numOne+numTwo;
                }
            }
        }
        // sort the sums
        Collections.sort(abundantNumberSums);

        System.err.println("Adding up all non-sums...");
        int j = 0; // index of abundant number sum to compare to
        int sum = 0;
        // for each positive integer up to 28123,
        for (int i = 1; i < num; i++) {
            // figure out if it can be written as the sum of two abundant numbers
            // if not, add to final sum
            while (abundantNumberSums.get(j) < i) {
                j++;
            }
            if (abundantNumberSums.get(j) > i) {
                sum += i;
            } else if (abundantNumberSums.get(j) == i) {
                j++;
            }
        }

        System.out.println("The sum of all the positive integers"
                        + " that cannot be written as the sum of"
                        + " two abundant numbers is " + sum);
    }

    public static ArrayList<Integer> calculateAbundantNumbersTo(int x) {
        // do something to calculate abundant numbers
        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
        for (int i = 1; i <= x; i++) {
            //System.err.println(i);
            ArrayList<Integer> properDivisors = getProperDivisors(i);
            //System.err.println(properDivisors);
            int sum = 0;
            for (int j = 0; j < properDivisors.size(); j++) {
                sum += properDivisors.get(j);
            }
            if (sum > i) {
                abundantNumbers.add(i);
            }
        }
        return abundantNumbers;
    }

    public static ArrayList<Integer> getProperDivisors(int x) {
        ArrayList<Integer> properDivisors = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                properDivisors.add(i);
                if (i != 1 && x/i != i) {
                    properDivisors.add(x/i);
                }
            }
        }
        return properDivisors;
    }
}
