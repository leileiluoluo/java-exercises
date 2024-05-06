import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ComparableTest {

    @Test
    public void testArraysSort() {
        Telephone[] telephones = new Telephone[]{
                new Telephone(86, "010", 89150405),
                new Telephone(86, "010", 56249829),
                new Telephone(86, "0411", 66177118),
                new Telephone(86, "0411", 39966686)
        };

        Arrays.sort(telephones);

        Arrays.stream(telephones).forEach(System.out::println);
    }

}
