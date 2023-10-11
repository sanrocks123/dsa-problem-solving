/* (C) 2019 */
package general;

import org.junit.jupiter.api.Test;

interface AA {
    int a = 10;

    default void defaultPrintMethod() {
        System.out.println("Interface A");
    }

    abstract void displaySAM();
}

interface BB {

    default void defaultPrintMethod() {
        System.out.println("Interface B");
    }

    abstract void displaySAM();
}

class A {

    public A(int i) {}

    protected void display() throws NullPointerException {
        System.out.println("A");
    }
}

class B extends A implements AA, BB {
    int a = 20;

    /**
     * @param i
     */
    public B(int i) {
        super(12);
    }

    @Override
    public void defaultPrintMethod() {
        a++;
        System.out.println(a);
        BB.super.defaultPrintMethod();
    }

    @Override
    public void displaySAM() {
        // TODO Auto-generated method stub
    }
}

public class DefaultInterfaceOverridingTest {

    @Test
    public void test() {
        // final A a = new B(100);
        // a.display();

        new B(10).defaultPrintMethod();
    }
}
