import java.util.*; // for ArrayList
import java.math.*;

/**
* @author Claire Jaja
* @version 9/28/14
*
* Project Euler Problem 19
* 1 Jan 1900 was a Monday.
* Thirty days has September,
* April, June, and November.
* All the rest have thirty-one,
* Saving February alone,
* Which has twenty-eight, rain or shine.
* And on leap years, twenty-nine.
* A leap year occurs on any year evenly divisibly by 4,
* but not on a century unless it is divisibly by 400.
* How many Sundays fell on the first of the month during the twentieth century
* (1 Jan 1901 to 31 Dec 2000)?
*/

public class CountingSundays {
    // global variable for days per month
    private static final Map<Integer,Integer> daysPerMonth = new HashMap<Integer,Integer>();
    static {
        daysPerMonth.put(1,31);
        daysPerMonth.put(2,28);
        daysPerMonth.put(3,31);
        daysPerMonth.put(4,30);
        daysPerMonth.put(5,31);
        daysPerMonth.put(6,30);
        daysPerMonth.put(7,31);
        daysPerMonth.put(8,31);
        daysPerMonth.put(9,30);
        daysPerMonth.put(10,31);
        daysPerMonth.put(11,30);
        daysPerMonth.put(12,31);
    }

    public static void main(String[] args) {
        int firstOfTheMonthSundays = 0;
        // since 1 Jan 1900 was a Monday
        // 1 Jan 1901 was a Tuesday
        // since it was 365 days (= 52 weeks + 1 day) later
        // will use 1 - 7 to represent days of the week, starting with Sunday
        int firstOfTheMonth = 3;
        boolean leapYear = false;
        // loop through all years
        for (int i = 1901; i <= 2000; i++) {
            // figure out if it's a leap year
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                leapYear = true;
            } else {
                leapYear = false;
            }
            // loop though all months
            // use 1 - 12 to represent months
            for (int j = 1; j <= 12; j++) {
                // unless it's Dec 2000
                if (!(i == 2000 && j == 12)) {
                    // figure out the first of NEXT month
                    int numDays = daysPerMonth.get(j);
                    // special logic for leap year February
                    if (leapYear && j == 2) {
                        numDays++;
                    }
                    firstOfTheMonth += numDays % 7;
                    if (firstOfTheMonth > 7) {
                        firstOfTheMonth = firstOfTheMonth % 7;
                    }
                    // if it's a Sunday, add to sum
                    if (firstOfTheMonth == 1) {
                        firstOfTheMonthSundays++;
                    }
                }
            }
        }
        System.out.println("There were " + firstOfTheMonthSundays
                        + " Sundays that fell on the first of the month"
                        + " during the twentieth century.");
    }
}
