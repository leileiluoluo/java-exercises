import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    @Test
    public void testArraySort() {
        Telephone[] telephones = new Telephone[]{
                new Telephone(86, "010", 89150405),
                new Telephone(86, "010", 56249829),
                new Telephone(86, "0411", 66177118),
                new Telephone(86, "0411", 39966686)
        };

        // sort arrays
        Arrays.sort(telephones, (o1, o2) -> Comparator.comparingInt(Telephone::getCountryCode)
                .thenComparing(Telephone::getAreaCode)
                .thenComparingInt(Telephone::getNumber)
                .compare(o2, o1));

        // print
        Arrays.stream(telephones).forEach(System.out::println);
    }

}
