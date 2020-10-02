import java.time.LocalDate;

public class JavaDateAndTime {

    public static String findDay(int month, int day, int year) {
        int d = Integer.valueOf(day);
        int m = Integer.valueOf(month);
        int y = Integer.valueOf(year);
        LocalDate date = LocalDate.of(y, m, d);
        return date.getDayOfWeek().toString();

    }
}
