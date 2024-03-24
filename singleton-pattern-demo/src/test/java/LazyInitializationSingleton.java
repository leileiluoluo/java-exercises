public class LazyInitializationSingleton {
    private static LazyInitializationSingleton INSTANCE = null;

    private LazyInitializationSingleton() {
    }

    public static LazyInitializationSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyInitializationSingleton();
        }
        return INSTANCE;
    }
}
