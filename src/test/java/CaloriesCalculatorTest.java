import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-04 23:43
 */
public class CaloriesCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "true,110,5,1,12,1464.3",
            "true,180,7,2,42,2023.8",
            "false,110,5,1,12,1358.3",
            "false,120,6,0,39,1326.1"
    }
    )
    public void shouldCalculateCaloriesCorrect(boolean isMate, Double weight, Double feet, Double inches, Double age, String expectedCalories) {
        CaloriesCalculator caloriesCalculator = new CaloriesCalculator();
        double calculateCalories = caloriesCalculator.calculateCalories(isMate, weight, feet, inches, age);
        String formatCalculateCalories = caloriesCalculator.format(calculateCalories);
        assertEquals(expectedCalories, formatCalculateCalories);

    }
}