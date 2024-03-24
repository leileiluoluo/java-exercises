import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonReflectionTest {
    @Test
    public void testTwoInstancesCreation() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = null;

        Constructor<?>[] constructors = ThreadSafeSingleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            singleton2 = (ThreadSafeSingleton) constructor.newInstance();
        }

        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
