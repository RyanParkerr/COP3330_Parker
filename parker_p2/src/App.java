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
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        System.out.println("BMI VALUES");
        System.out.println("Underweight <= 18.5");
        System.out.println("Normal weight = 18.5 - 24.9");
        System.out.println("Overweight = 25 - 29.9");
        System.out.println("Obesity = BMI of 30 or Greater");
    }
    /* Scans in the user's height */
    private static double getUserHeight() {
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
            }
            else {
                loop = false;
            }
        }
        return userHeight;
    }
    /* Scans in the user's weight */
    private static double getUserWeight() {
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
            }
            else {
                loop = false;
            }
        }
        return userWeight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {

        System.out.println("Your BMI is: %d%n", bmi);
    }

    /* a Boolean function that will return true or false based on if the user enters y or n */
    public static Boolean moreInput() {

        Scanner sc = new Scanner(System.in);
        String decision;
        boolean yn = true;
        boolean loop = true;

        System.out.println("Would you like to add Additional Input?");

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