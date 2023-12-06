import org.junit.jupiter.api.Test;

public class JavaBeansPatternTest {

    static class RedisConfig {
        private String host; // 必填
        private Integer port = 6379; // 可选，默认为 6379
        private Integer maxTotal = 100; // 可选，默认为 100
        private Integer maxIdle = 10; // 可选，默认为 10
        private Integer maxWaitMillis = 60 * 1000 * 1000; // 可选，默认为 1 分钟
        private Boolean testOnBorrow = true; // 可选，默认为 true

        public RedisConfig() {
        }

        public void setHost(String host) {
            this.host = host;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public void setMaxTotal(Integer maxTotal) {
            this.maxTotal = maxTotal;
        }

        public void setMaxIdle(Integer maxIdle) {
            this.maxIdle = maxIdle;
        }

        public void setMaxWaitMillis(Integer maxWaitMillis) {
            this.maxWaitMillis = maxWaitMillis;
        }

        public void setTestOnBorrow(Boolean testOnBorrow) {
            this.testOnBorrow = testOnBorrow;
        }
    }

    @Test
    public void testConstruction() {
        RedisConfig config = new RedisConfig();
        config.setHost("localhost");
        config.setPort(6380);
        config.setMaxTotal(200);
        config.setMaxIdle(20);
        config.setMaxWaitMillis(120 * 1000 * 1000);
        config.setTestOnBorrow(false);
    }

}
