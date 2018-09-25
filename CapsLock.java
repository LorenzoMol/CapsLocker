import java.util.Scanner;
import java.util.ArrayList;

/**
 *  Class that capitalizes and undo capitalization of a given word.
 */

public class CapsLock {

    /**
     *
     * @param input sentence that needs to be capitalized
     * @return sentence with capitalization performed
     */

    public static String capsLocker(String input) {

        if (input == null) {
            return null;
        }

        ArrayList locationA = new ArrayList();

        String inputLower = input.toLowerCase();
        String output = "";
        String beginning = "";
        char[] inputChar = inputLower.toCharArray();

        // calculate the position of the A;
        for (int i = 0; i < input.length(); i++) {
            if (inputChar[i] == 'a') {
                locationA.add(i);
            }
        }

        // capitalize when next A come; if it's in an even position,
        // I have to capitalize; if it's in an odd position, I need to
        // undo capitalization.
        for (int i = 0; i < locationA.size(); i++) {
            if (i % 2 == 0 && i == 0) {
                //capitalize whatever comes next i and the beginning
                beginning = input.substring(0, (int) locationA.get(i));
                output = beginning + (input.substring((int) locationA.get(i) + 1, (int) locationA.get(i + 1))).toUpperCase();
            }

            if (i % 2 == 1) {
                //lowercase whatever comes next i
                output = output + input.substring((int) locationA.get(i) + 1, input.length()).toLowerCase();
            }


            if (i % 2 == 0 && i != 0) {
                if (i == locationA.size() - 1) {
                    output = output + (input.substring((int) locationA.get(i) + 1, locationA.size())).toUpperCase();
                } else {
                    output = output + (input.substring((int) locationA.get(i) + 1, (int) locationA.get(i + 1))).toUpperCase();
                }
            }
        }
        return output;
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String line = scan.nextLine();

        System.out.println(capsLocker(line));
    }

}

