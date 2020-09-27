import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Do NOT Edit this Main !!!
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {

            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    // Only Edit Past This Point.

    private void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        int i;
        double total = 0;
        double average = 0;

        for(i = 0; i < bmiData.size; i++) {
            total += bmiData.bmiScore[i];
        }
        average = total / bmiDate.size;

        System.out.println("The average BMI for this input is " + average);
    }

    /* Scans in the user's height */
    private double getUserHeight() {
        double userHeight = 0;
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        /* A while loop that confirms the user enters a positive value */
        while(loop) {
            System.out.println("Enter your Height in inches:");
            userHeight = sc.nextDouble();

            /* If the user enters a negative value this will prompt the user to enter another value */
            if (userHeight <= 0) {
                System.out.println("Negative numbers not supported");
                sc.nextLine();
            }
            else {
                loop = false;
            }
        }
        return userHeight;
    }

    /* Scans in the user's weight */
    private double getUserWeight() {
        double userWeight = 0;
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        /* A while loop that confirms the user enters a positive value */
        while(loop) {
            System.out.println("Enter your Weight in pounds:");
            userWeight = sc.nextDouble();

            /* If the user enters a negative value this will prompt the user to enter another value */
            if (userWeight <= 0) {
                System.out.println("Negative numbers not supported");
                sc.nextLine();
            }
            else {
                loop = false;
            }
        }
        return userWeight;
    }

    private void displayBmiInfo(BodyMassIndex bmi) {

        System.out.println("Your BMI is: " + bmi.bmiScore);

        if(bmi.bmiCatagory = "Underweight") {
            System.out.println("And you are Underweight according to the National " +
                    "Heart Lung and Blood Institution.\n");
        }
        else if(bmi.bmiCatagory = "Normal Weight") {
            System.out.println("And you are Normal Weight according to the National " +
                    "Heart Lung and Blood Institution.\n");
        }
        else if(bmi.bmiCatagory = "Overweight") {
            System.out.println("And you are Overweight according to the National " +
                    "Heart Lung and Blood Institution.\n");
        }
        else {
            System.out.println("And you are Obese according to the National " +
                    "Heart Lung and Blood Institution.\n");
        }
    }

    /* a Boolean function that will return true or false based on if the user enters y or n */
    private static Boolean moreInput() {

        Scanner sc = new Scanner(System.in);
        String decision;
        boolean yn = true;
        boolean loop = true;

        System.out.println("Would you like to add An Input?");

        /* a while loop that will continue to loop if the user enters an invalid entry */
        while(loop) {

            System.out.println("ENTER <Y> for Yes or <N> for No:");
            decision = sc.nextLine();

            /* a switch statement that confirms the user entered a Y or a N and it not will continue the above loop */
            switch (decision) {
                case "Y":
                    yn = true;
                    loop = false;
                    break;
                case "N":
                    yn = false;
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid entry");
                    loop = true;
                    break;
            }
        }
        return yn;
    }
}
