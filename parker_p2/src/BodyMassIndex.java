public class BodyMassIndex {
    double bmiScore;
    String bmiCatagory;

    public class BodyMassIndex(double height, double weight) {
        this.bmiScore = (703 * weight) / (height * height);

        if(this.bmiScore <= 18.5) {
            this.bmiCatagory = "Underweight";
        } else if(this.bmiScore <= 18.5) {
            this.bmiCatagory = "Normal Weight";
        } else if(this.bmiScore <= 18.5) {
            this.bmiCatagory = "Overweight";
        } else {
            this.bmiCatagory = "Obese";
        }
    }
}
