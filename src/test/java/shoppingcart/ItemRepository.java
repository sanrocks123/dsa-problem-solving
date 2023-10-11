/* (C) 2017 */
package shoppingcart;

/**
 * Java Source ItemRepository.java created on Nov 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public interface ItemRepository {

    /**
     * @return
     */
    public Item getItemByCode(String code);
}
