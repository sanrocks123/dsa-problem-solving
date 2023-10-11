/* (C) 2017 */
package shoppingcart;

import java.math.BigDecimal;

/**
 * Java Source Item.java created on Nov 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class Item {

    private String barCode;
    private String name;
    private BigDecimal price;
    private int qty;

    /**
     * @param string
     * @param string2
     * @param bigDecimal
     */
    public Item(String barCode, String name, BigDecimal price) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (barCode == null) {
            if (other.barCode != null) {
                return false;
            }
        } else if (!barCode.equals(other.barCode)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /**
     * @return the barCode
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (barCode == null ? 0 : barCode.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    /**
     * @param barCode the barCode to set
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
}
