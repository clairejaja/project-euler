import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 1/13/14
*
* Project Euler Problem 4
* Largest palindrome product
* A palindromic number reads the same both ways.
* The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
* Find the largest palindrome made from the product of two 3-digit numbers.
*/

public class LargestPalindromeProduct
{
	public static void main(String[] args) {
        ArrayList<Integer> palindromeProducts = new ArrayList<Integer>();
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i*j;
                if (isPalindrome(product)) {
                    palindromeProducts.add(product);
                }
            }
        }

        Collections.sort(palindromeProducts);

        System.out.println(palindromeProducts.get(palindromeProducts.size()-1));

    }

    public static boolean isPalindrome(int num) {
        String strNum = Integer.toString(num);
        String strNumReverse = new StringBuffer(strNum).reverse().toString();
        if (strNum.equals(strNumReverse)) {
            return true;
        }
        return false;
    }

}
