/* (C) 2023 */
package domain;

/**
 * Java Source ImmutableClass.java created on Dec 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ImmutableClass {
    final int id;

    public ImmutableClass(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
