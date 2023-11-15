import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class InstantUtil {

    public static Instant str2Instant(String dateTimeStr, String pattern) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(pattern)
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();

        return LocalDateTime.parse(dateTimeStr, formatter)
                .atZone(ZoneId.systemDefault())
                .toInstant();
    }

    public static String instant2Str(Instant instant, String pattern) {
        return DateTimeFormatter.ofPattern(pattern)
                .withZone(ZoneId.systemDefault())
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