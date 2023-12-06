import org.junit.jupiter.api.Test;

public class TelescopingConstructorPatternTest {

    static class RedisConfig {
        private final String host; // 必填
        private Integer port = 6379; // 可选，默认为 6379
        private Integer maxTotal = 100; // 可选，默认为 100
        private Integer maxIdle = 10; // 可选，默认为 10
        private Integer maxWaitMillis = 60 * 1000 * 1000; // 可选，默认为 1 分钟
        private Boolean testOnBorrow = true; // 可选，默认为 true

        public RedisConfig(String host) {
            this.host = host;
        }

        public RedisConfig(String host, Integer port) {
            this(host);
            this.port = port;
        }

        public RedisConfig(String host, Integer port, Integer maxTotal) {
            this(host, port);
            this.maxTotal = maxTotal;
        }

        public RedisConfig(String host, Integer port,
                           Integer maxTotal, Integer maxIdle) {
            this(host, port, maxTotal);
            this.maxIdle = maxIdle;
        }

        public RedisConfig(String host, Integer port,
                           Integer maxTotal, Integer maxIdle,
                           Integer maxWaitMillis) {
            this(host, port, maxTotal, maxIdle);
            this.maxWaitMillis = maxWaitMillis;
        }

        public RedisConfig(String host, Integer port,
                           Integer maxTotal, Integer maxIdle,
                           Integer maxWaitMillis, Boolean testOnBorrow) {
            this(host, port, maxTotal, maxIdle, maxWaitMillis);
            this.testOnBorrow = testOnBorrow;
        }
    }

    @Test
    public void testConstruction() {
        // 设置某个字段时，需要找到包含该字段的最短参数列表来进行设置
        RedisConfig config = new RedisConfig("localhost", 6379, 100, 10, 60 * 1000 * 1000, false);
    }

}
