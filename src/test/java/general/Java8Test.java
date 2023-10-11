/* (C) 2019 */
package general;

import domain.Employee;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source Java8Test.java created on Dec 19, 2019
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class Java8Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testFlatMap() {
        final Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        final List<String> phones =
                people.values().stream().flatMap(m -> m.stream()).collect(Collectors.toList());
        log.info("phones {}", phones);
    }

    @Test
    public void testFlatMapOperations() {
        final List<Employee> employees = new CopyOnWriteArrayList<>();

        employees.add(new Employee(3, "A"));
        employees.add(new Employee(1, "B"));
        employees.add(new Employee(2, "C"));

        final Predicate<Employee> filter = (e) -> e.getEmpId() > 0;

        final long count =
                employees.stream()
                        .filter(filter)
                        .peek(e -> log.info("e: {}", e.getName()))
                        .mapToInt(Employee::getEmpId)
                        .count();

        log.info("count: {}, cc: {}", count, employees.size());

        employees.stream();
    }

    @Test
    public void testOptional() {

        String s1 = new String("Hello");
        Optional<String> sOpt = Optional.of(s1);

        log.info("optional: {}", sOpt.get());

        s1 = "";
        sOpt = Optional.of(s1);

        log.info("s1, after null reference: {}", sOpt.orElse(""));
    }

    @Test
    public void testStreamExample() {
        final List<Employee> employees = new CopyOnWriteArrayList<>();

        employees.add(new Employee(3, "A"));
        employees.add(new Employee(1, "B"));
        employees.add(new Employee(2, "C"));

        log.info("all emps: {}", employees);
        for (final Employee employee : employees) {
            log.info("e {}", employee);
            employees.add(new Employee(4, "D"));
        }

        final Comparator<Employee> byName =
                (e1, e2) -> {
                    return e1.getName().compareTo(e2.getName());
                };

        log.info("Sum {}", employees.stream().mapToInt(zz -> zz.getEmpId()).sum());

        Collections.sort(employees, byName);
        log.info("After SORT, empList: {}", employees);

        final List<Integer> number = Arrays.asList(2, 3, 4, 5, 3);
        final List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());

        log.info("Numbers: {}", square);

        final int sum =
                Arrays.stream(new int[] {1, 2, 3}).filter(i -> i >= 2).map(i -> i * 3).sum();
        log.info("sum {}", sum);
    }

    @Test
    public void testStreamsReducer() {
        final List<Employee> employees = new CopyOnWriteArrayList<>();

        employees.add(new Employee(3, "A"));
        employees.add(new Employee(1, "B"));
        employees.add(new Employee(2, "C"));

        final Predicate<Employee> filter = (e) -> e.getEmpId() > 0;

        final long count =
                employees.stream()
                        .filter(filter)
                        .peek(e -> log.info("e: {}", e.getName()))
                        .mapToInt(e -> e.getEmpId())
                        .count();

        log.info("count: {}, cc: {}", count, employees.size());
    }
}
