/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:37
 */
public class MalePerson extends Person {
    public MalePerson(Double weight, Double feet, Double inches, Double age) {
        super(weight, feet, inches, age);
    }

    
    public double mateCalculate(Double weight, Double feet, Double inches, Double age) {
        return 66
                + (6.3 * weight)
                + (12.9 * ((feet * 12)
                + inches))
                - (6.8 * age);
    }
}
