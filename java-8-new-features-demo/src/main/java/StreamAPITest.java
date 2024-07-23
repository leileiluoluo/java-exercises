import java.util.List;

public class StreamAPITest {

    public static void main(String[] args) {
        List<String> languages = List.of("java", "golang", "python", "php", "javascript");
        languages.stream()
                .filter(lang -> lang.length() < 8)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

}
