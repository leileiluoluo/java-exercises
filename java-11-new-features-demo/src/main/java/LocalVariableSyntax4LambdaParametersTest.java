import java.util.function.BiFunction;
import java.util.function.Function;

public class LocalVariableSyntax4LambdaParametersTest {

    public @interface NonNull {
    }

    public static void main(String[] args) {
        // Java 10：显式类型 Lambda 表达式
        Function<String, String> toUpperCase = (String s) -> s.toUpperCase();

        // Java 10：隐式类型 Lambda 表达式
        Function<String, String> toUpperCase2 = s -> s.toUpperCase();

        // Java 11：局部变量语法（var）在隐式类型 Lambda 表达式中的使用
        Function<String, String> toUpperCase3 = (var s) -> s.toUpperCase();

        // Java 11：局部变量语法与注解结合使用
        BiFunction<Integer, Integer, Integer> sum = (@NonNull var a, @NonNull var b) -> a + b;
    }

}
