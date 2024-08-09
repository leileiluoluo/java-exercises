import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class NewHTTPClientAPITest {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 构建 HttpClient 对象
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMinutes(1))
                .build();

        // 构建 HttpRequest 对象
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://leileiluoluo.com"))
                .GET()
                .build();

        // 同步请求
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        // 异步请求
        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        futureResponse.thenApply(HttpResponse::body) // 获取响应体
                .thenAccept(System.out::println) // 打印响应体
                .join(); // 等待所有操作完成
    }

}
