/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020-03-05 00:37
 */
public class MalePerson extends Person {

    public MalePerson() {
        super();
    }

    @Override
    public double calculate(Double weight, Double feet, Double inches, Double age) {
        return 66
                + (6.3 * weight)
                + (12.9 * ((feet * 12)
                + inches))
                - (6.8 * age);
    }
}
