public class LambdaFeatureTest {

    public static void main(String[] args) {
        // 使用匿名类创建 Runnable 接口的实例
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a new thread started!");
            }
        }).start();

        // 使用 Lambda 表达创建 Runnable 接口的实例
        new Thread(() -> System.out.println("a new thread started!")).start();

        // 使用匿名类创建 MyInterface 接口的实例
        MyInterface myInterface1 = new MyInterface() {
            @Override
            public void print(String str) {
                System.out.println(str);
            }
        };
        myInterface1.print("my functional interface called");

        // 使用 Lambda 表达创建 MyInterface 接口的实例
        MyInterface myInterface2 = System.out::println;
        myInterface2.print("my functional interface called");
    }

}