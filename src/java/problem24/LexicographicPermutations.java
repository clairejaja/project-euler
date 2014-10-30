import java.util.*; // for ArrayList
import java.math.*;
import java.io.*;

/**
* @author Claire Jaja
* @version 10/14/14
*
* Project Euler Problem 24
* A permutation is an ordered arrangement of objects.
* For example, 3124 is one possible permutation of the digits 1, 2, 3, and 4.
* If all of the permutations are listed numerically or alphabetically,
* we call it lexicographic order. The lexicographic permutations
* of 0, 1, and 2 are:
* 012, 021, 102, 120, 201, 210
* What is the millionth lexicographic permtuation of the digits
* 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9?
*/

public class LexicographicPermutations {
    public static void main(String[] args) {
        int[] digits = new int[] {0,1,2,3,4,5,6,7,8,9};
        int nth = 1000000; // find 1 millionth permutation 
        // total number of permutations = n!
        int numPermutations = calculateFactorial(digits.length);
        System.err.println(numPermutations);

        int[] nthPermutation = new int[digits.length];
        // find one digit at a time
        for (int i = 0; i < digits.length; i++) {
            // to get ith digit
            // figure out break point between possible digits there
        }
    }

    public static int calculateFactorial(int n) {
        int factorial = 1L;
        for (int i = 1; i <= n; i++) {
            factorial *= (int)i;
        }
        return factorial;
    }
}
