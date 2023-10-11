package dsa;

import org.junit.jupiter.api.Test;

public class RecursionTest {

    @Test
    public void factorial() {
        int n = 5;
        int result = fact(n);
        System.out.printf("result : %s", result);
    }

    private int fact(final int n) {

        if (n == 0) {
            return 1;
        }
        System.out.printf("%d X ", n);
        return n * fact(n - 1);
    }
}
