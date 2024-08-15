import java.lang.constant.ConstantDesc;
import java.lang.invoke.MethodHandles;

public class StringAPIEnhancementsTest {

    public static void main(String[] args) {
        // indent() 方法使用
        System.out.println("Hello, World!".indent(4)); // "    Hello, World!"

        // transform() 方法使用
        String after = "Hello, World!".transform(String::toUpperCase)
                .transform(str -> new StringBuffer(str).reverse().toString());
        System.out.println(after); // "!DLROW ,OLLEH"

        // resolveConstantDesc() 方法使用
        ConstantDesc constantDesc = "Hello, World!".resolveConstantDesc(MethodHandles.lookup());
        System.out.println(constantDesc); // "Hello, World!"
    }

}
