
package com.practice;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldCalculateAverage() {
        GradeCalculator calculator = new GradeCalculator();

        double result = calculator.calculateAverage(80, 91);

        assertEquals(85.5, result, 0.001);
    }
}
