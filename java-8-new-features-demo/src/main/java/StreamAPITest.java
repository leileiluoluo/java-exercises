import java.util.List;
import java.util.stream.IntStream;

public class StreamAPITest {

    public static void main(String[] args) {
        // 生成一个 [1, 2, ..., 100] 的数组，然后对每个元素求平方后进行求和
        long sum = IntStream.rangeClosed(0, 100)
                .mapToLong(num -> (long) num * num)
                .sum();
        System.out.println(sum);

        // 对 List 进行过滤、映射、排序后进行打印
        List<String> languages = List.of("java", "golang", "python", "php", "javascript");
        languages.stream()
                .filter(lang -> lang.length() < 8)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

}
