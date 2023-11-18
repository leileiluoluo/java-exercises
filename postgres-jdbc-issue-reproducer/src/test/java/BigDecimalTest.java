import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigDecimalTest {

    @Test
    public void test() throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "postgres")) {
            var sql = "SELECT price FROM product WHERE id=1";

            try (var stmt = conn.prepareStatement(sql)) {
                var priceInserted = new BigDecimal("20000.00000000");

                for (int round = 0; round < 10; round++) {
                    try (var rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            var price = rs.getBigDecimal("price");

                            assertEquals(priceInserted, price, "assertion failed in round " + round);
                        }
                    }
                }
            }
        }
    }

}
