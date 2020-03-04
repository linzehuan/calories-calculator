/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:25
 */
public class Person {

    private double baseCalories;
    private double weightFactor;
    private double heightFactor;
    private double ageFactor;

    public Person(double baseCalories, double weightFactor, double heightFactor, double ageFactor) {
         this.baseCalories = baseCalories;
         this.weightFactor = weightFactor;
         this.heightFactor =heightFactor;
         this.ageFactor = ageFactor;

    }

 

    public double calculate(Double weight, Double feet, Double inches, Double age) {

        return baseCalories
                + (weightFactor * weight)
                + (heightFactor * ((feet * 12)
                + inches))
                - (ageFactor * age);
    }
}
