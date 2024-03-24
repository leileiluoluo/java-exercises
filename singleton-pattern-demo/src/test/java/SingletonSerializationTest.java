import org.junit.jupiter.api.Test;

import java.io.*;

public class SingletonSerializationTest {
    @Test
    public void testTwoInstancesCreation() throws IOException, ClassNotFoundException {
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();

        // write object
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oss = new ObjectOutputStream(bos);

        oss.writeObject(singleton1);
        oss.close();

        // read object
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        ThreadSafeSingleton singleton2 = (ThreadSafeSingleton) ois.readObject();
        ois.close();

        // print
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
