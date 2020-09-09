import javax.swing.text.StringContent;

public class Encrypter {

    public static String encrypt(String inputCode) {
        // initializes new int val
        int inputCodeVal = 0;
        // converts string into an int
        try {
            inputCodeVal = Integer.parseInt(inputCode);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int first;
        int second;
        int third;
        int fourth;

        // Uses remainders to establish each of the four integers
        first = inputCodeVal / 1000;
        second = (inputCodeVal % 1000) / 100;
        third = (inputCodeVal % 100) / 10;
        fourth = (inputCodeVal % 10);

        /* Changes the integers by adding 7 to each and finding the remainders
           after dividing by 10 */
        first = (first + 7) % 10;
        second = (second + 7) % 10;
        third = (third + 7) % 10;
        fourth = (fourth + 7) % 10;

        //swaps the places of integers 1 / 3 and 2 / 4
        int encryptedCodeInt = (third * 1000 + fourth * 100 + first * 10 + second);

        // returns the encrypted integer back to a string
        String encryptedCodeString = String.format ("%04d", encryptedCodeInt);

        System.out.println("The encrypted Code is " + encryptedCodeString);

        return (encryptedCodeString);
    }
}
