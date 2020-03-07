import java.util.LinkedHashMap;

/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/7 10:30 下午
 */
public class CalorieInfo {


    private final double baseCalories;
    private final double weightFactor;
    private final double heightFactor;
    private final double ageFactor;

    private final static LinkedHashMap<Sex, CalorieInfo> sexCaloriesInfo = new LinkedHashMap<>();

     static {
        sexCaloriesInfo.put(Sex.MALE, new CalorieInfo(66, 6.3, 12.9, 6.8));
        sexCaloriesInfo.put(Sex.FEMALE, new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put(Sex.X1, new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put(Sex.X2, new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put(Sex.X3, new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put(Sex.X4, new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put(Sex.X5, new CalorieInfo(655, 4.3, 4.7, 4.7));
    }

    public CalorieInfo(double baseCalories, double weightFactor, double heightFactor, double ageFactor) {
        this.baseCalories = baseCalories;
        this.weightFactor = weightFactor;
        this.heightFactor = heightFactor;
        this.ageFactor = ageFactor;
    }

    public static double calculateCalories(Double weight, Double inches, Double feet, Double age, Sex selectSex) {
        CalorieInfo caloriesInfo = sexCaloriesInfo.get(selectSex);
        return caloriesInfo.calculate(weight, inches, feet, age);
    }
    public double calculate(Double weight, Double inches, Double feet, Double age) {
        return baseCalories
                + weightFactor * weight
                + heightFactor * (feet * 12 + inches)
                - ageFactor * age;
    }
}
