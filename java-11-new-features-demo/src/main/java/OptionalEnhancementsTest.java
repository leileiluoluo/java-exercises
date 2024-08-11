import java.util.Optional;

public class OptionalEnhancementsTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        if (optional.isEmpty()) {
            System.out.println("Optional is empty");
        }
    }

}
