/* (C) 2023 */
package domain;

import java.io.Serializable;
import org.json.JSONObject;

public class Counter implements Serializable {

    private static final long serialVersionUID = 1L;
    volatile int x = 1;
    int y = 2;
    double doub = 123_456.0;
    private int count = 0;
    private Employee emp;
    private boolean isEnable = false;

    /**
     * public Counter copy() { try { return new ObjectMapper().readValue(new
     * JSONObject(this).toString(), Counter.class); } catch (final IOException e) { throw new
     * RuntimeException("Object Clone Failure", e); } }
     */

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
        final Counter other = (Counter) obj;
        if (count != other.count) {
            return false;
        }
        if (emp == null) {
            if (other.emp != null) {
                return false;
            }
        } else if (!emp.equals(other.emp)) {
            return false;
        }
        if (isEnable != other.isEnable) {
            return false;
        }
        return true;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the emp
     */
    public Employee getEmp() {
        return emp;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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
        result = prime * result + count;
        result = prime * result + (emp == null ? 0 : emp.hashCode());
        result = prime * result + (isEnable ? 1231 : 1237);
        return result;
    }

    /**
     * @return the isEnable
     */
    public boolean isEnable() {
        return isEnable;
    }

    /**
     * @param isEnable the isEnable to set
     */
    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public void m1() {
        x = 11;
        y = 22;
    }

    public void m2() {
        x = 22;
        y = 33;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
