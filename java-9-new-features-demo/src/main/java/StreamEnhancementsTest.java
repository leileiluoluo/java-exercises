import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEnhancementsTest {

    public static void main(String[] args) {
        // ofNullable() 使用样例
        String name = null;
        List<String> names = Stream.ofNullable(name)
                .collect(Collectors.toList());
        System.out.println(names); // []

        // takeWhile() 使用样例
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 3, 2, 1)
                .takeWhile(num -> num < 4)
                .collect(Collectors.toList());
        System.out.println(numbers); // [1, 2, 3]

        // dropWhile() 使用样例
        List<Integer> numbers2 = Stream.of(1, 2, 3, 4, 3, 2, 1)
                .dropWhile(num -> num < 4)
                .collect(Collectors.toList());
        System.out.println(numbers2); // [4, 3, 2, 1]

        // iterate() 使用样例，Java 8 版本
        List<Integer> oddNumbers = Stream.iterate(1, v -> v + 2)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(oddNumbers); // [1, 3, 5, 7, 9]

        // iterate() 使用样例，Java 9 版本
        List<Integer> oddNumbers2 = Stream.iterate(1, v -> v < 10, v -> v + 2)
                .collect(Collectors.toList());
        System.out.println(oddNumbers2); // [1, 3, 5, 7, 9]
    }

}
