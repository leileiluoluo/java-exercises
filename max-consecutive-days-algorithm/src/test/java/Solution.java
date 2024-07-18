import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Solution {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static long getDurationDays(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1, DATE_FORMATTER);
        LocalDate localDate2 = LocalDate.parse(date2, DATE_FORMATTER);

        return ChronoUnit.DAYS.between(localDate1, localDate2);
    }

    private static int getMaxConsecutiveDays(List<String> dates) {
        int maxConsecutiveDays = 1;
        int candidateMaxConsecutiveDays = 1;

        String previousDate = dates.get(0);
        for (int i = 1; i < dates.size(); i++) {
            String currentDate = dates.get(i);
            if (1 == getDurationDays(previousDate, currentDate)) {
                candidateMaxConsecutiveDays++;
            } else {
                candidateMaxConsecutiveDays = 1;
            }

            if (candidateMaxConsecutiveDays > maxConsecutiveDays) {
                maxConsecutiveDays = candidateMaxConsecutiveDays;
            }

            previousDate = currentDate;
        }

        return maxConsecutiveDays;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> logins = new HashMap<>();

        try (InputStream inputStream = Solution.class.getResourceAsStream("login.log")) {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(" ");
                String id = items[0];
                String date = items[1];

                if (!logins.containsKey(id)) {
                    logins.put(id, new TreeSet<>(Collections.singleton(date)));
                } else {
                    Set<String> dates = logins.get(id);
                    dates.add(date);
                    logins.put(id, dates);
                }
            }

            // print result
            logins.forEach((id, dates) -> System.out.println(id + ": " + getMaxConsecutiveDays(dates.stream().toList())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
