import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DateTimeAPITest {

    public static void main(String[] args) throws InterruptedException {
        // 使用 Instant 和 Duration 计算时间差
        Instant start = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toSeconds()); // 1

        // 使用 LocalDate 计算下个月的今天，并使用 Period 计算两个日期的间隔月数
        LocalDate localDate = LocalDate.now();
        LocalDate localDateNextMonth = localDate.plusMonths(1);
        System.out.println(localDateNextMonth); // 2024-08-23
        Period period = Period.between(localDate, localDateNextMonth);
        System.out.println(period.getMonths()); // 1

        // 打印当前时区，获取当前 ZonedDateTime 并使用 DateTimeFormatter 后进行打印；然后转换为洛杉矶 ZonedDateTime 后进行格式化并打印
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId currentTimeZone = ZoneId.systemDefault();
        System.out.println(currentTimeZone); // "Asia/Shanghai"
        ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now();
        System.out.println(shanghaiZonedDateTime.format(formatter)); // 2024-07-23 13:08:15
        ZonedDateTime losangelesZonedDateTime = shanghaiZonedDateTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println(losangelesZonedDateTime.format(formatter)); // 2024-07-22 22:08:15
    }

}
