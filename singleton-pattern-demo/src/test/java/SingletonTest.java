import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void testMultiThreadedAccessing() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance());
            }).start();
        }
    }
}
