public class Decrypter {

    public static String decrypt(String inputCode) {
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

        /* Changes the integers by adding 3 to each and finding the remainders
           after dividing by 10 */
        first = (first + 3) % 10;
        second = (second + 3) % 10;
        third = (third + 3) % 10;
        fourth = (fourth + 3) % 10;

        //swaps the places of integers 1 / 3 and 2 / 4
        int decryptedCodeInt = (third * 1000 + fourth * 100 + first * 10 + second);

        // returns the decrypted integer back to a string
        String decryptedCodeString = String.format("%04d", decryptedCodeInt);

        System.out.println("The decrypted Code is " + decryptedCodeString);

        return (decryptedCodeString);
    }
}
