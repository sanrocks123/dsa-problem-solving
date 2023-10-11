/* (C) 2023 */
package domain;

/**
 * Java Source ExtendedImmutableClass.java created on Jan 4, 2020
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ExtendedImmutableClass extends ImmutableClass {
    int overrideId;

    public ExtendedImmutableClass(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return this.overrideId;
    }

    public Integer printVal(Integer arg) {
        return arg;
    }

    public Object printVal(Object arg) {
        return arg;
    }

    public String printVal(String arg) {
        return arg;
    }

    public void setId(int id) {
        this.overrideId = id;
    }
}
