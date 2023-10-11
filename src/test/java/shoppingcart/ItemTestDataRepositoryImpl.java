/* (C) 2017 */
package shoppingcart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Source ItemRepositoryImpl.java created on Nov 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ItemTestDataRepositoryImpl implements ItemRepository {

    private final Map<String, Item> items = new HashMap<>();

    /** */
    public ItemTestDataRepositoryImpl() {
        items.put("01001", new Item("01001", "Lemon", new BigDecimal("1.60")));
        items.put("01002", new Item("01003", "Apple", new BigDecimal("1.30")));
        items.put("01003", new Item("01003", "Mango", new BigDecimal("0.99")));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sanrocks.operationsimpl.ItemRepository#getItemByCode()
     */
    @Override
    public Item getItemByCode(String code) {
        return items.get(code);
    }
}
