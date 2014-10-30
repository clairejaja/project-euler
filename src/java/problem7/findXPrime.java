import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 9/11/14
*
* Project Euler Problem 7
* By listing the first six prime numbers: 2, 3, 5, 7, 11, 13,
* we can see that the 6th prime is 13.
* What is the 10,001st prime number?
*/

public class findXPrime
{
    public static void main(String[] args) {
        // first command line argument is position of prime to find
        int x = 0;
        if (args.length > 0) {
            try {
                x = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        // initialize with first prime
        int primePosition = 1;
        int prime = 2;

        while (primePosition < x) {
            // find next prime
            int i = prime + 1;
            boolean foundNextPrime = false;
            while (!foundNextPrime) {
                int j = 2;
                while (j < Math.sqrt(i) && i % j != 0) {
                    j++;
                }
                if (i % j != 0) {
                    foundNextPrime = true;
                    prime = i;
                    primePosition++;
                } else {
                    i++;
                }
            }
        }
    System.out.println(prime);
    }
}
