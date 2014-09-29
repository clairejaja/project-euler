import java.util.*; // for ArrayList
import java.math.*;

/**
* @author Claire Jaja
* @version 9/28/14
*
* Project Euler Problem 21
* Let d(n) be defined as the sum of proper divisors of n
* (numbers less than n which divide evenly into n)
* If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair
* and each of a and b are called amicable numbers.
* For example, the proper divisors of 220 are
* 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, and 110; therefore d(220) = 284.
* The proper divisors of 284 are 1, 2, 4, 71, and 142; so (284) = 220.
* Evaluate the sum of all the amicable numbers under 10000.
*/

public class AmicableNumbers {
    public static void main(String[] args) {
        int num = 10000;
        // calculate and store d(n) for each number n
        Map<Integer,Integer> divisorSums = new HashMap<Integer,Integer>();
        for (int i = 2; i < num; i++) {
            divisorSums.put(i,d(i));
        }
        // find amicable pairs
        ArrayList<Integer> amicableNumbers = new ArrayList<Integer>();
        for (int i = 2; i < divisorSums.size(); i++) {
            int divisorSum = divisorSums.get(i);
            if (divisorSum > 1
                && divisorSum < num
                && i != divisorSum
                && divisorSums.get(divisorSum) == i) {
                amicableNumbers.add(i);
            }
        }

        // calculate sum of amicable numbers
        int sum = 0;
        for (int i = 0; i < amicableNumbers.size(); i++) {
            sum += amicableNumbers.get(i);
        }

    System.out.println("The sum of all the amicable numbers under 10000 is "
                        + sum);
    }

    public static int d(int n) {
        // find proper divisors of n
        ArrayList<Integer> properDivisors = new ArrayList<Integer>();
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                properDivisors.add(i);
            }
        }
        // return sum of proper divisors
        int sum = 0;
        for (int i = 0; i < properDivisors.size(); i++) {
            sum += properDivisors.get(i);
        }
        return sum;
    }
}
