import java.util.*; // for ArrayList
import java.math.*;

/**
* @author Claire Jaja
* @version 9/25/14
*
* Project Euler Problem 16
* 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
* What is the sum of the digits of the number 2^1000
*/

public class PowerDigitSum {
    public static void main(String[] args) {
        // argument is the power to raise 2 to
        int power = 1000; // if no arguments, use 1000
        if (args.length > 0) {
            try {
                power = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        // get the actual number
        // it's very big so need to use BigDecimal
        BigDecimal base = new BigDecimal("2.0");
        BigDecimal raisedToPower = base.pow(power);

        // store as array of digits
        ArrayList<Integer> digitArray = new ArrayList<Integer>();
        String strRaisedToPower = raisedToPower.toString();
        for (int i = 0; i < strRaisedToPower.indexOf('.'); i++) {
            char digit = strRaisedToPower.charAt(i);
            digitArray.add(Character.getNumericValue(digit));
        }

        // now sum digits
        long sum = 0;
        for (int i = 0; i < digitArray.size(); i++) {
            sum += digitArray.get(i);
        }

        System.out.println("The sum of the digits of 2^"+power+" is "+sum);

    }
}
