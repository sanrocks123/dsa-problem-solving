/* (C) 2019 */
package general;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source CollectionTest.java created on Dec 21, 2019
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class CollectionTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testBinarySearch() {
        final List<String> str = Arrays.asList("mumbai", "pune", "new york", "sydney");
        Collections.sort(str);

        log.info("sorted list: {}", str);
    }

    @Test
    public void testCollectionEqualsTest() {
        final List<String> str = Arrays.asList("a", "b", "c", "a");
        final Set<String> set = new HashSet<>(str);
        final Set<String> ss = new TreeSet<>(str);
        Assertions.assertEquals(set, ss);
    }

    @Test()
    public void testIteratorRemoval() {

        UnsupportedOperationException exception =
                Assertions.assertThrows(
                        UnsupportedOperationException.class,
                        () -> {
                            final List<String> list = Arrays.asList("a", "b", "c", "a");
                            final Iterator<String> itr = list.iterator();
                            list.remove("a");
                            while (itr.hasNext()) {
                                System.out.println(itr.next());
                            }
                        });
    }

    @Test
    public void testMaxValueInMap() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 5);
        map.put("c", 2);
        map.put("d", 1);

        final int max =
                map.entrySet().stream()
                        .max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1)
                        .get()
                        .getValue();
        System.out.printf("max value: %d", max);
    }

    @Test
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void testUnrelatedListObjects() {

        final List list = new ArrayList();
        list.add("2");
        list.add(3);
        list.add(null);

        log.info("list: {}", list);
    }
}
