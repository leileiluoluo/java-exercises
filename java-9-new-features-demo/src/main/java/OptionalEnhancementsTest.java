import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalEnhancementsTest {

    public static void main(String[] args) {
        // 使用 or() 方法设置备选值
        Optional<String> optional = Optional.empty();
        String result = optional.or(() -> Optional.of("Default value"))
                .orElse("Other value");
        System.out.println(result); // Default value

        // 使用 stream() 方法将 Optional 转换为 Stream
        List<String> names = Optional.of("Larry")
                .stream()
                .collect(Collectors.toList());
        System.out.println(names); // [Larry]

        // 使用 ifPresentOrElse() 方法执行操作
        Optional.empty()
                .ifPresentOrElse(
                        value -> System.out.println("Value: " + value),
                        () -> System.out.println("No value is present")
                ); // No value present
    }

}
