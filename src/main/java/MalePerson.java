/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:37
 */
public class MalePerson extends Person {


    public MalePerson() {
        super();
        baseCalories = 66;
        weightFactor = 6.3;
        heightFactor = 12.9;
        ageFactor = 6.8;
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
