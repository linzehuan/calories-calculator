import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/7 6:31 下午
 */
public class CaloriesCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "Male,110,5,1,12,1464.3",
            "Male,180,7,2,42,2023.8",
            "Female,110,5,1,12,1358.3",
            "Female,120,6,0,39,1326.1" ,
            "x3,120,6,0,39,1326.1" ,
            "x5,120,6,0,39,1326.1"
    }
    )
    public void shouldCalculateCaloriesCorrect(String sex, Double weight, Double feet, Double inches, Double age, String expectedCalories) {
        CaloriesCalculator cc = new CaloriesCalculator();
        double calculateCalories = cc.calculateCalories(weight,inches,feet,age,sex);
        String formatCalculateCalories = cc.format(calculateCalories);
        assertEquals(expectedCalories, formatCalculateCalories);
    }
}