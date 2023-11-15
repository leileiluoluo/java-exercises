import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date str2Date(String dateStr, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("date parse failed");
        }
    }

    public static String date2Str(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static void main(String[] args) {
        // string to date
        Date date = DateUtil.str2Date("2023-11-15", "yyyy-MM-dd");

        // date to string
        String str = DateUtil.date2Str(date, "yyyy/MM");
        System.out.println(str);
    }

}
