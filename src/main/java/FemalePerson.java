/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:44
 */
public class FemalePerson extends Person {
    public FemalePerson(Double weight, Double feet, Double inches, Double age) {
        super();
    }
    public double calculate(Double weight, Double feet, Double inches, Double age){
        return 655
                + (4.3 * weight)
                + (4.7 * ((feet * 12)
                + inches))
                - (4.7 * age);
    }
}
