public class BodyMassIndex {
    double bmiScore;
    String bmiCategory;

    /* Calculates the BMI number */
    public BodyMassIndex(double height, double weight) {
        this.bmiScore = (703 * weight) / (height * height);

        if(this.bmiScore < 18.5) {
            this.bmiCategory = "Underweight";
        } else if(this.bmiScore <= 24.9) {
            this.bmiCategory = "Normal Weight";
        } else if(this.bmiScore <= 29.9) {
            this.bmiCategory = "Overweight";
        } else {
            this.bmiCategory = "Obese";
        }
    }
    public double getScore() {
        return this.bmiScore;
    }
}
