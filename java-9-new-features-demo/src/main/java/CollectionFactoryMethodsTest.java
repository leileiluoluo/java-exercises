import java.util.*;

public class CollectionFactoryMethodsTest {

    public static void main(String[] args) {
        // Java 8: creating an unmodifiable list
        List<String> names = Arrays.asList("a", "b", "c");
        names = Collections.unmodifiableList(names);

        // Java 9: creating an unmodifiable list
        List<String> names2 = List.of("Larry", "Lucy", "Jacky");

        // Java 8: creating an unmodifiable set
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3));
        numbers = Collections.unmodifiableSet(numbers);

        // Java 9: creating an unmodifiable set
        Set<Integer> numbers2 = Set.of(1, 2, 3);

        // Java 8: creating an unmodifiable map
        Map<String, Integer> nameAgeMap = new HashMap<>();
        nameAgeMap.put("Larry", 18);
        nameAgeMap.put("Lucy", 28);
        nameAgeMap.put("Jacky", 29);
        nameAgeMap = Collections.unmodifiableMap(nameAgeMap);

        // Java 9: creating an unmodifiable map
        Map<String, Integer> nameAgeMap2 = Map.of("Larry", 18, "Lucy", 28, "Jacky", 29);
    }

}
