import java.io.Serial;
import java.io.Serializable;

public class ThreadSafeSingleton implements Serializable {
    @Serial
    private static final long serialVersionUID = -2269217301316756303L;

    private static ThreadSafeSingleton INSTANCE = null;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (ThreadSafeSingleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new ThreadSafeSingleton();
                }
            }
        }
        return INSTANCE;
    }

    @Serial
    private Object readResolve() {
        return getInstance();
    }
}
