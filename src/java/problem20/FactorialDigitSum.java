import java.util.*; // for ArrayList
import java.math.*;

/**
* @author Claire Jaja
* @version 9/28/14
*
* Project Euler Problem 20
* n! means n * (n-1) * ... * 3 * 2 * 1
* For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800,
* and the sum of the digits in the number 10!
* is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27
* Find the sum of the digits in the number 100!
*/

public class FactorialDigitSum {
    public static void main(String[] args) {
        // argument is n to compute factorial to
        int n = 100; // default value 100
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        // calculate n!
        // will be quite big so let's use BigInteger
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(new BigInteger(i+""));
        }

        // store as array of digits
        ArrayList<Integer> digitArray = new ArrayList<Integer>();
        String strFactorial = factorial.toString();
        for (int i = 0; i < strFactorial.length(); i++) {
            char digit = strFactorial.charAt(i);
            digitArray.add(Character.getNumericValue(digit));
        }

        // sum the digits
        int sum = 0;
        for (int i = 0; i < digitArray.size(); i++) {
            sum += digitArray.get(i);
        }

        System.out.println("The sum of the digits of " + n + "! is " + sum);

    }
}
