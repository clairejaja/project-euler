import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 9/22/14
*
* Project Euler Problem 14
* The following iterative sequence is defined for the set of positive integers:
* n -> n/2 (n is even)
* n -> 3n+1 (n is odd)
* Using the rule above and starting with 13, we generate the following sequence:
* 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
* It can be seen that this sequence (starting at 13 and finishing at 1)
* contains 10 terms. Although it has not been proved yet
* (Collatz Problem), it is thought that all starting numbers finish at 1.
* Which starting number, under one million, produces the longest chain?
*/

public class LongestCollatzSequence {
    public static void main(String[] args) {
        // variable for highest starting number
        int startingNum = 1000000;
        // variable for longest chain found
        int longestChainStartingNum = 0;
        int longestChain = 0;

        // store chain lengths as they are discovered
        // in array where the index is the starting number
        // since terms can exceed starting number, initialize array up to 10n
        int[] chainLengths = new int[10*startingNum];
        
        // calculate chain length for each startingNum
        for (int i = startingNum-1; i > 0; i--) {
            long currentNum = i;
            int chainLength = 1;
            // use (unproven) assumption that all starting numbers finish at 1
            while (currentNum != 1) {
                // check if I already know the chain length from here
                if (currentNum > 0 && currentNum < chainLengths.length
                && chainLengths[(int)currentNum] != 0) {
                    chainLength += chainLengths[(int)currentNum]-1;
                    currentNum = 1;
                } else if (currentNum % 2 == 0) { // even number
                    chainLength += 1;
                    currentNum = currentNum / 2;
                } else { // odd number
                    chainLength += 1;
                    currentNum = 3 * currentNum + 1;
                }
            }
            // store for later retrieval
            chainLengths[i] = chainLength;
            // check if longest
            if (chainLength > longestChain) {
                longestChainStartingNum = i;
                longestChain = chainLength;
            }
        }
    System.out.println("The starting number under " + startingNum +
                        " with the longest chain is " +
                        longestChainStartingNum + " with a chain length of " +
                        longestChain);
    }
}
