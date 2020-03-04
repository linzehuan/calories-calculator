/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:44
 */
public class FemalePerson extends Person {

    private double baseCalories;
    private double weightFactor;
    private double heightFactor;
    private double ageFactor;

    public FemalePerson() {
        super();
        baseCalories = 655;
        weightFactor = 4.3;
        heightFactor = 4.7;
        ageFactor = 4.7;
    }

    @Override
    public double calculate(Double weight, Double feet, Double inches, Double age) {

        return baseCalories
                + (weightFactor * weight)
                + (heightFactor * ((feet * 12)
                + inches))
                - (ageFactor * age);
    }
}
