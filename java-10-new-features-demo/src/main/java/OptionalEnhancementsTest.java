import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalEnhancementsTest {

    public static void main(String[] args) {
        // 使用 orElseThrow() 抛出自定义异常
        Optional.empty()
                .orElseThrow(() -> new NoSuchElementException("值不存在"));
    }

}
