import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 9/11/14
*
* Project Euler Problem 9
* A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
* a^2 + b^2 = c^2
* For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2
* There exists exactly one Pythagorean triplet for which a + b + c = 1000.
* Find the product abc.
*/

public class specialPythagoreanTriplet
{
    public static void main(String[] args) {
        boolean tripletFound = false;
        double c = 900; // c will be this or lower
        double a = 999-c;
        double b = 1000-c-a;
        while (!tripletFound) { // stop when answer is found
            c--;
            double c_squared = Math.pow(c,2.0);
            // must add up to 1000
            a = 1000-c;
            while (a > (1000-c)/2 && !tripletFound) {
                a--;
                b = 1000-c-a;
                // a^2 + b^2 must equal c^2
                double a_squared = Math.pow(a,2.0);
                double b_squared = Math.pow(b,2.0);
                if (a_squared + b_squared == c_squared) {
                    tripletFound = true;
                    }
                }
        }

        double product = a * b * c;
        System.out.println((long)product);
    }
}
