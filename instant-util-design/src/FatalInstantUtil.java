import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FatalInstantUtil {

    public static Instant str2Instant(String dateTimeStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        return LocalDateTime.parse(dateTimeStr, formatter)
                .atZone(ZoneId.systemDefault())
                .toInstant();
    }

    public static String instant2Str(Instant instant, String pattern) {
        return DateTimeFormatter.ofPattern(pattern)
                .format(instant);
    }

    public static void main(String[] args) {
        // string to instant
        Instant instant = str2Instant("2023-11-15", "yyyy-MM-dd");
        System.out.println(instant);

        // instant to string
        String str = instant2Str(Instant.now(), "yyyy-MM");
        System.out.println(str);
    }

}