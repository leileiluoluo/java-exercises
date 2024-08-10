import java.util.Arrays;
import java.util.List;

public class CollectionEnhancementsTest {

    public static void main(String[] args) {
        // Java 1.6：调用 List 的 `Object[] toArray()` 方法
        Object[] names = Arrays.asList("Larry", "Jacky", "Alice").toArray();

        // Java 1.6：调用 List 的 `T[] toArray(T[] a)` 方法
        String[] names1 = Arrays.asList("Larry", "Jacky", "Alice").toArray(new String[3]);

        // Java 11：调用 Collection 的 `toArray(IntFunction<T[]> generator)` 方法
        String[] names2 = List.of("Larry", "Jacky", "Alice")
                .toArray(String[]::new);
    }

}
