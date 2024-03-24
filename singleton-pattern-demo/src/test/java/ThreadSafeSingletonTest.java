import org.junit.jupiter.api.Test;

public class ThreadSafeSingletonTest {
    @Test
    public void testMultiThreadedAccessing() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(ThreadSafeSingleton.getInstance());
            }).start();
        }
    }
}
