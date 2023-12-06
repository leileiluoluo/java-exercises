import org.junit.jupiter.api.Test;

public class BuilderPatternTest {

    static class RedisConfig {
        private final String host;
        private final Integer port;
        private final Integer maxTotal;
        private final Integer maxIdle;
        private final Integer maxWaitMillis;
        private final Boolean testOnBorrow;

        static class Builder {
            private String host; // 必填
            private Integer port = 6379; // 可选，默认为 6379
            private Integer maxTotal = 100; // 可选，默认为 100
            private Integer maxIdle = 10; // 可选，默认为 10
            private Integer maxWaitMillis = 60 * 1000 * 1000; // 可选，默认为 1 分钟
            private Boolean testOnBorrow = true; // 可选，默认为 true

            public Builder(String host) {
                this.host = host;
            }

            public Builder port(Integer port) {
                this.port = port;
                return this;
            }

            public Builder maxTotal(Integer maxTotal) {
                this.maxTotal = maxTotal;
                return this;
            }

            public Builder maxIdle(Integer maxIdle) {
                this.maxIdle = maxIdle;
                return this;
            }

            public Builder maxWaitMillis(Integer maxWaitMillis) {
                this.maxWaitMillis = maxWaitMillis;
                return this;
            }

            public Builder testOnBorrow(Boolean testOnBorrow) {
                this.testOnBorrow = testOnBorrow;
                return this;
            }

            public RedisConfig build() {
                return new RedisConfig(this);
            }
        }

        private RedisConfig(Builder builder) {
            this.host = builder.host;
            this.port = builder.port;
            this.maxTotal = builder.maxTotal;
            this.maxIdle = builder.maxIdle;
            this.maxWaitMillis = builder.maxWaitMillis;
            this.testOnBorrow = builder.testOnBorrow;
        }
    }

    @Test
    public void testConstruction() {
        RedisConfig config = new RedisConfig.Builder("localhost")
                .port(6380)
                .maxTotal(200)
                .maxIdle(20)
                .maxWaitMillis(120 * 1000 * 1000)
                .testOnBorrow(false)
                .build();
    }

}
