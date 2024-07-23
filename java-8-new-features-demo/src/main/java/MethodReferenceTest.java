import java.util.List;

public class MethodReferenceTest {

    static class Language {
        private final String name;

        public Language(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<String> languages = List.of("java", "golang", "python", "php", "javascript");
        languages.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Language[] languageArray = languages.stream()
                .map(Language::new)
                .toArray(Language[]::new);
    }

}
