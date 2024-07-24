import java.util.Arrays;
import java.util.List;

public class TypeInferenceTest {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(names);
    }

}
