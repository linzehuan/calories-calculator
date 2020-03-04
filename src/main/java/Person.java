/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:25
 */
public class Person {

    public Person(Double weight, Double feet, Double inches, Double age) {

    }

    public double femaleCalculate(Double weight, Double feet, Double inches, Double age) {
        return 655
                + (4.3 * weight)
                + (4.7 * ((feet * 12)
                + inches))
                - (4.7 * age);
    }

    public double mateCalculate(Double weight, Double feet, Double inches, Double age) {
        return 66
                + (6.3 * weight)
                + (12.9 * ((feet * 12)
                + inches))
                - (6.8 * age);
    }
}
