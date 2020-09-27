import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    @Test
    void testBmiUnderWeight() {
        BodyMassIndex score = new BodyMassIndex(80, 100);
        assertEquals("Underweight", score.bmiCategory);
    }

    @Test
    void testBmiCatNormalWeight() {
        BodyMassIndex score = new BodyMassIndex(75, 160);
        assertEquals("Normal Weight", score.bmiCategory);
    }
    @Test
    void testBmiCatOverweight() {
        BodyMassIndex score = new BodyMassIndex(70, 200);
        assertEquals("Overweight", score.bmiCategory);
    }
    @Test
    void testBmiCatObese() {
        BodyMassIndex score = new BodyMassIndex(10, 200);
        assertEquals("Obese", score.bmiCategory);
    }

    @Test
    void testBmiScore() {
        BodyMassIndex score = new BodyMassIndex(80, 100);
        assertEquals(10.984375, score.bmiScore);
    }
}