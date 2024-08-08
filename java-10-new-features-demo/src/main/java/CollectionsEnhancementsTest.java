import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsEnhancementsTest {

    static class Student {
        private final String name;
        private final int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        // 根据原 List、Set 和 Map，使用 copyOf 创建一个不可变的 List、Set 和 Map
        List<String> originalList = new ArrayList<>();
        List<String> immutableList = List.copyOf(originalList);

        Set<String> originalSet = new HashSet<>();
        Set<String> immutableSet = Set.copyOf(originalSet);

        Map<String, Integer> originalMap = new HashMap<>();
        Map<String, Integer> immutableMap = Map.copyOf(originalMap);

        // 转换为不可修改的 List、Set 和 Map
        List<Integer> unmodifiableList = Stream.of(1, 2, 3)
                .collect(Collectors.toUnmodifiableList());

        Set<String> unmodifiableSet = Stream.of("Larry", "Jacky", "Alice")
                .collect(Collectors.toUnmodifiableSet());

        Map<String, Integer> unmodifiableMap = Stream.of(
                new Student("Larry", 28),
                new Student("Jacky", 29),
                new Student("Alice", 19)
        ).collect(Collectors.toUnmodifiableMap(
                Student::getName,
                Student::getAge)
        );
    }
}
