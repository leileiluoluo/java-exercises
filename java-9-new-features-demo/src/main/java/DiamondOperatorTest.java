import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiamondOperatorTest {

    public static void main(String[] args) {
        // Java 8 以前，需要显式指定泛型参数
        List<String> list1 = new ArrayList<String>();

        // 在 Java 8 中，可以使用钻石操作符进行推断
        List<String> list2 = new ArrayList<>();

        // 在 Java 8 中，无法在匿名内部类中使用钻石操作符
        // 而在 Java 9 中则可以
        Runnable runnable = () -> {
            List<String> list = new ArrayList<>(); // 自动推断为 ArrayList<String>
            list.add("Java 9");
            System.out.println("Inside Runnable: " + list);
        };

        // 在 Java 9 中更复杂的嵌套泛型也能正确推断
        Map<String, List<Map<Integer, String>>> complexMap = new HashMap<>();
    }

}
