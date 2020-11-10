import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test04 {
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final int SECONDS_PER_DAY = (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
    private static final long DAY_MILLISECONDS = SECONDS_PER_DAY * 1000L;

    private static SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        double date=2958446;
        int wholeDays = (int)Math.floor(date);
        System.out.println(wholeDays);
        int millisecondsInDay = (int)((date - wholeDays) * DAY_MILLISECONDS + 0.5);
        System.out.println(millisecondsInDay);
        Calendar calendar = new GregorianCalendar(); // using default time-zone
        setCalendar(calendar, wholeDays, millisecondsInDay, false);
        System.out.println(sdFormat.format(calendar.getTime()));
    }
    public static void setCalendar(Calendar calendar, int wholeDays,
                                   int millisecondsInDay, boolean use1904windowing) {
        int startYear = 1900;
        int dayAdjust = -1; // Excel thinks 2/29/1900 is a valid date, which it isn't
        if (use1904windowing) {
            startYear = 1904;
            dayAdjust = 1; // 1904 date windowing uses 1/2/1904 as the first day
        }
        else if (wholeDays < 61) {
            // Date is prior to 3/1/1900, so adjust because Excel thinks 2/29/1900 exists
            // If Excel date == 2/29/1900, will become 3/1/1900 in Java representation
            dayAdjust = 0;
        }
        calendar.set(startYear,0, wholeDays + dayAdjust, 0, 0, 0);
        calendar.set(GregorianCalendar.MILLISECOND, millisecondsInDay);
    }
}
