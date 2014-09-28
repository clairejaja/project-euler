import java.util.*; // for ArrayList
import java.math.*;

/**
* @author Claire Jaja
* @version 9/27/14
*
* Project Euler Problem 17
* If the numbers 1 to 5 are written out in words: one, two, three, four, five,
* then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
* If all the numbers from 1 to 1000 (one thousand) inclusive were written out
* in words, how many letters would be used?
*/

public class NumberLetterCounts {
    // global variable for the basic digits
    private static final Map<Integer,String> digits = new HashMap<Integer,String>();
    static {
        digits.put(1,"one");
        digits.put(2,"two");
        digits.put(3,"three");
        digits.put(4,"four");
        digits.put(5,"five");
        digits.put(6,"six");
        digits.put(7,"seven");
        digits.put(8,"eight");
        digits.put(9,"nine");
    }
    // global variable for 10 - 19
    private static final Map<Integer,String> teens = new HashMap<Integer,String>();
    static {
        teens.put(10,"ten");
        teens.put(11,"eleven");
        teens.put(12,"twelve");
        teens.put(13,"thirteen");
        teens.put(14,"fourteen");
        teens.put(15,"fifteen");
        teens.put(16,"sixteen");
        teens.put(17,"seventeen");
        teens.put(18,"eighteen");
        teens.put(19,"nineteen");
    }

    // global variable for multiples of ten
    private static final Map<Integer,String> tens = new HashMap<Integer,String>();
    static {
        tens.put(20,"twenty");
        tens.put(30,"thirty");
        tens.put(30,"thirty");
        tens.put(40,"forty");
        tens.put(50,"fifty");
        tens.put(60,"sixty");
        tens.put(70,"seventy");
        tens.put(80,"eighty");
        tens.put(90,"ninety");
    }

    public static void main(String[] args) {
        // argument is the number (inclusive) to count letters to
        int num = 1000; // if no arguments, use 1000
        if (args.length > 0) {
            try {
                num = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        int letterCount = 0;
        // loop through, write out each number, count its letters
        for (int i = 1; i <= num; i++) {
            // write out the number
            String numberWord = writeOutNumber(i);
            // count the letters
            letterCount += numberWord.length();
        }
        System.out.println("If all the numbers from 1 to " + num
                            + " are wrriten out in words, " + letterCount
                            + " letters would be used.");
    }

    // note - could memoize results for faster runtime if needed
    public static String writeOutNumber(int num) {
        // if number is less than 20, just return the word
        if (num < 10) {
            return digits.get(num);
        }
        if (num < 20) {
            return teens.get(num);
        }
        // less than 100 is pretty simple
        if (num < 100) {
            if (num % 10 == 0) {
                return tens.get(num);
            }
            return tens.get(num-(num%10)) + digits.get(num%10);
        }
        // now can only print out higher parts
        // and call this function to print out the end
        if (num < 1000) {
            if (num % 100 == 0) {
                return digits.get(num/100) + "hundred";
            }
            return digits.get(num/100) + "hundredand"
                            + writeOutNumber(num%100);
        }
        if (num < 1000000) {
            if (num % 1000 == 0) {
                return writeOutNumber(num/1000) + "thousand";
            }
            return writeOutNumber(num/1000) + "thousandand"
                        + writeOutNumber(num%1000);
        }
        throw new Error("Numbers this large are not yet implemented!");
    }
}
