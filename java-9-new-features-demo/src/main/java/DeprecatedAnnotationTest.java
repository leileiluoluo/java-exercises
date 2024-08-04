public class DeprecatedAnnotationTest {

    @Deprecated(since = "9", forRemoval = true)
    public static void method1() {
        // 旧的方法实现
    }

    @Deprecated(since = "10") // forRemoval = false
    public static void method2() {
        // 废弃的方法实现
    }

    public static void main(String[] args) {
        DeprecatedAnnotationTest.method1();
        DeprecatedAnnotationTest.method2();
    }

}
