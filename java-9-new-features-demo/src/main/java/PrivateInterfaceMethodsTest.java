public class PrivateInterfaceMethodsTest {

    public interface MyInterface {
        void abstractMethod();

        default void defaultMethod() {
            int result = privateMethod();
            System.out.println("Result: " + result);
        }

        static void staticMethod() {
            int result = privateStaticMethod();
            System.out.println("Result: " + result);
        }

        private int privateMethod() {
            return 28;
        }

        private static int privateStaticMethod() {
            return 39;
        }
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void abstractMethod() {
                System.out.println("Abstract Method Implemented!");
            }
        };

        myInterface.abstractMethod(); // Abstract Method Implemented!
        myInterface.defaultMethod(); // Result: 28
        MyInterface.staticMethod(); // Result: 39
    }

}
