import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocalVariableTypeReferenceTest {

    public static void main(String[] args) {
        // 在基础类型变量声明、泛型类型变量声明中使用 var
        var num = 10; // int num = 10;
        var message = "Hello World!"; // String message = "Hello World!";
        var list = new ArrayList<Map<String, List<Integer>>>(); // List<Map<String, List<Integer>>> list = new ArrayList<>();

        // 在普通 for 循环中使用 var
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // 在增强型 for 循环使用 var
        for (var str : List.of("Larry", "Jacky", "Alice")) {
            System.out.println(str);
        }

        // 在 try-with-resources 语句中使用 var
        String filePath = LocalVariableTypeReferenceTest.class.getResource("test.txt").getPath();
        try (var br = new BufferedReader(new FileReader(filePath))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
