@FunctionalInterface
public interface MyInterface {

    // 抽象方法
    void print(String str);

    // 默认方法
    default int version() {
        return 1;
    }

    // 静态方法
    static String info() {
        return "functional interface test";
    }
}
