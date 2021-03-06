package javaeuler.euler;

import javaeuler.tools.EulerReader;

public class Euler008 {
    public static void main(String[] args) {
        EulerReader fileReader= new EulerReader("resources/Euler008.txt");

        // creating fileContents from the contents of the file
        // after removing all newline characters
        String fileContents = fileReader.read().replaceAll("[\r\n]", "");

        long result = 0;
        long mulResult;

        // iterate through file contents by each 13-length substring
        // and for each substring get the multiplication of all it's
        // digits and compare them against the last largest result
        // and overwriting the last result with the new result if
        // the new result is larger
        for (int i=0; i + 13 < fileContents.length(); i++) {
            mulResult = mul(fileContents.substring(i, i+13));
            if (mulResult > result) {
                result = mulResult;
            }
        }

        System.out.println(result);
    }

    private static long mul(String substring) {
        long result = 1;
        for (Character i : substring.toCharArray()) {
            long num = Character.getNumericValue(i);
            result *= num;
        }
        return result;
    }
}
