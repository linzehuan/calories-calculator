/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:25
 */
public class Person {

    protected double baseCalories;
    protected double weightFactor;
    protected double heightFactor;
    protected double ageFactor;

    public Person() {
         baseCalories = 0;
         weightFactor = 0;
         heightFactor =0;
         ageFactor = 0;

    }

 

    public double calculate(Double weight, Double feet, Double inches, Double age) {

        return baseCalories
                + (weightFactor * weight)
                + (heightFactor * ((feet * 12)
                + inches))
                - (ageFactor * age);
    }
}
