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

    public CalorieInfo(double baseCalories, double weightFactor, double heightFactor, double ageFactor) {

        this.baseCalories = baseCalories;
        this.weightFactor = weightFactor;
        this.heightFactor = heightFactor;
        this.ageFactor = ageFactor;
    }

    public double calculate(Double weight, Double inches, Double feet, Double age) {
        return baseCalories
                + weightFactor * weight
                + heightFactor * (feet * 12 + inches)
                - ageFactor * age;
    }
}
