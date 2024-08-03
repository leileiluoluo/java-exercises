import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) {
        // 使用 CompletableFuture 进行异步计算
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                // 模拟耗时操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        // 使用 CompletableFuture 处理异步计算结果，这里需要两个任务都完成
        CompletableFuture<Integer> allFutures = CompletableFuture.allOf(future1, future2)
                .thenApply(result -> future1.join() + future2.join());

        // 等待所有任务完成
        System.out.println(allFutures.join());
    }

}
