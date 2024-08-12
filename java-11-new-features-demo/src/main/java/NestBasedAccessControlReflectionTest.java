import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NestBasedAccessControlReflectionTest {

    private int number = 10;

    private void printOuter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Inner inner = new Inner();
        final Method method = Inner.class.getDeclaredMethod("printInner");
        method.invoke(inner);
    }

    private class Inner {
        private void printInner() {
            number += 10;
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        new NestBasedAccessControlReflectionTest().printOuter();
    }

}
