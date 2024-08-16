import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatAPIEnhancementsTest {

    public static void main(String[] args) {
        // 数字紧凑显示（美国，长样式）
        NumberFormat usCompactFormatLong = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(usCompactFormatLong.format(10000)); // 10 thousand
        System.out.println(usCompactFormatLong.format(10000000)); // 10 million

        // 数字紧凑显示（美国，短样式）
        NumberFormat usCompactFormatShort = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(usCompactFormatShort.format(10000)); // 10K
        System.out.println(usCompactFormatShort.format(10000000)); // 10M

        // 数字紧凑显示（中国，短样式）
        NumberFormat cnCompactFormat = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
        System.out.println(cnCompactFormat.format(10000)); // 1万
        System.out.println(cnCompactFormat.format(10000000)); // 1000万
    }

}
