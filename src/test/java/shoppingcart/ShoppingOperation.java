/* (C) 2017 */
package shoppingcart;

/**
 * Java Source ShoppingOperation.java created on Nov 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public interface ShoppingOperation {

    /**
     * Adding items
     *
     * @param item
     * @return
     */
    public Item addItem(String barCode);

    /**
     * @return
     */
    public int count();

    /** */
    public void summary();
}
