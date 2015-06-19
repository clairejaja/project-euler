import java.util.*; // for ArrayList
import java.math.*;

/**
* @author Claire Jaja
* @version 9/28/14
*
* Project Euler Problem 18
* By stating at the top of the triangle below and moving to adjacent numbers
* on the row below, the maximum total from top to bottom is 23.
*       3
*     7  4
*   2   4   6
* 8   5   9   3
* That is, 3 + 7 + 4 + 9 = 23
* Find the maximum total from top to bottom of the triangle below.
*/

public class MaximumPathSumI {
    // global variable 
    private static final int triangle[][] = new int[][] {
            {75},
            {95, 64},
            {17, 47, 82},                       
            {18, 35, 87, 10},
            {20, 4, 82, 47, 65},
            {19, 1, 23, 75, 3, 34},
            {88, 2, 77, 73, 7, 63, 67},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
                                                    };

    public static void main(String[] args) {
        // be clever
        // will work up from bottom
        // my actual max sum will be on [0][0] at the end
        int maxSum[][] = new int[triangle.length][];
        maxSum[triangle.length-1] = triangle[triangle.length-1];
        for (int i = triangle.length-1; i > 0; i--) {
            maxSum[i-1] = new int[i];
            for (int j = 0; j < i; j++) {
                // calculate max sum for this position
                // by adding max of two numbers below that are adjacent
                // to the number in that position
                    maxSum[i-1][j] = triangle[i-1][j]
                        + Math.max(maxSum[i][j], maxSum[i][j+1]);
            }
        }
        System.out.println("The maximum total from top to bottom "
                            + "of the triangle is "
                            + maxSum[0][0]);
    }
}
