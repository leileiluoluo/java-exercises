import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class AdderTest {

    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        DoubleAdder doubleAdder = new DoubleAdder();

        // 启动一个线程循环自增 100 次
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longAdder.increment();
                doubleAdder.add(0.5);
            }
        });
        thread.start();

        // 在主线程循环自增 100 次
        for (int i = 0; i < 100; i++) {
            longAdder.increment();
            doubleAdder.add(0.5);
        }

        // 等待 thread 执行完成
        thread.join();

        // 打印自增结果
        System.out.println(longAdder.sum());
        System.out.println(doubleAdder.sum());
    }

}
