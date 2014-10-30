import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 1/13/14
*
* Project Euler Problem 3
* Largest prime factor
* The prime factors of 13195 are 5, 7, 13, and 29.
* What is the largest prime factor of the number 600851475143?
*/

public class largestPrimeFactor
{
	// a global variable for the integer to calculate the largest prime factor of
	private static long num = 600851475143L;

	public static void main(String[] args) {
        // here's an array to hold all the factors
        ArrayList<Long> factors = new ArrayList<Long>();

        // calculate factors
        // only need to go up to the square root to get all of them
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num/i);
            }
        }

        // sort factors
        Collections.sort(factors);

        boolean largestPrimeFactorFound = false;
        int currentFactorPosition = factors.size()-1; // start with the largest factor
        long currentFactor = factors.get(currentFactorPosition);

        // until the largest prime factor is found
        while (!largestPrimeFactorFound) {
            if (isPrime(currentFactor)) { // check if the current factor is prime
                largestPrimeFactorFound = true;
                long largestPrimeFactor = currentFactor; // if so, it's the largest prime factor
                System.out.println(largestPrimeFactor);
            } else if (currentFactorPosition == 0) { // if somehow the end is reached without finding a prime factor
                largestPrimeFactorFound = true;
                long largestPrimeFactor = 1;
                System.out.println(largestPrimeFactor);
            } else { // if not, go to the next largest factor
                currentFactorPosition--;
                currentFactor = factors.get(currentFactorPosition);
            }
        }

    }

    public static boolean isPrime(long num) {
        for (long i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
                }
        }
        return true;
    }

}
