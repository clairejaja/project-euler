import java.util.*; // for ArrayList
import java.math.*;
import java.io.*;

/**
* @author Claire Jaja
* @version 9/28/14
*
* Project Euler Problem 22
* Using names.txt, a 46K text file containing over five-thousand first names,
* begin by sorting it into alphabetical order.
* Then working out the alphabetical value for each name,
* multiply this value by its alphabetical position in the list
* to obtain a name score.
*
* For example, when the list is sorted into alphabetical order,
* COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
* is the 938th name in the list.
* So, COLIN would obtain a score of 938 x 53 = 49714.
*
* What is the total of all the name scores in the file?
*/

public class NamesScores {
    public static void main(String[] args) throws IOException{
        // argument is file with names
        BufferedReader namesFile = null;
        try {
            namesFile = new BufferedReader(new FileReader(args[0]));
        } catch (IOException x) {
            System.err.println("IOException: " + x);
            System.exit(1);
        }

        // read in file to array
        String line = namesFile.readLine(); // all the names are on one line
        namesFile.close();
        String[] names = line.split(",");
        Arrays.sort(names); // sort will work even with quotes still there

        int nameScoresTotal = 0;
        int nameScore;
        for (int i = 0; i < names.length; i++) {
            String name = names[i].replaceAll("\"","");
            nameScore = 0;
            char[] nameChars = name.toCharArray();
            for (char c : nameChars) {
                nameScore += (int)c - 'A'+1;
            }
            nameScore *= i+1;
            nameScoresTotal += nameScore;
        }

        System.out.println("The total of all the name scores in the file is "
                            + nameScoresTotal);
    }
}
