import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 9/15/14
*
* Project Euler Problem 10
* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17
* Find the sum of all the primes below two million
*/

public class summationOfPrimes
{
    public static void main(String[] args) {
        // first command line argument is number to find sum of primes below
        int num = 0;
        if (args.length > 0) {
            try {
                num = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        } else {
            System.err.println("This script takes exactly one argument.");
            System.exit(1);
        }

        // run the sieve to find all primes up to the num
        ArrayList<Integer> primes = primeSieve(num);

        // sum up primes
        long primeSum = 0;
        for (Integer i : primes) {
            primeSum += i;
        }

        System.out.println(primeSum);
    }

    public static ArrayList<Integer> primeSieve(int num) {
        // initialize with all integers as prime
        boolean[] isPrime = new boolean[num+1];
        for (int i = 2; i <= num; i++) {
            isPrime[i] = true;
        }

        // eliminate non-primes
        // only need to go up to number squared to find all
        for (int i = 2; Math.pow(i,2) <= num; i++) {
            // if i is prime, mark its multiples as non-prime
            if (isPrime[i]) {
                for (int j = i; i*j <= num; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // return list of primes
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;

    }
}
