
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.GregorianCalendar;

public class Test2 {
    public long dateDiff(String startDate, String endDate) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar endGC = new GregorianCalendar();
        long times, days1 = 0l;
        try {
            times = sd.parse(endDate).getTime() - sd.parse(startDate).getTime();
            long days = times / (1000 * 24 * 60 * 60);
            days1 = (days / 7) * 5;
            long days2 = days % 7;
            endGC.setTime(sd.parse(endDate));
            int weekDay = endGC.get(Calendar.DAY_OF_WEEK);
            if (weekDay == 1) {
                days1 += days2 > 2 ? days2 - 2 : 0;
            } else if (weekDay == 7) {
                days1 += days2 > 1 ? days2 - 1 : 0;
            } else if (weekDay - 1 > days2) {
                days1 += days2;
            } else if (weekDay - 1 == days2) {
                days1 += weekDay - 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days1;
    }

    public static void main(String[] args) {
        String startDate = "2012-10-25";
        String endDate = "2012-12-24";
        System.out.println(new Test2().dateDiff(startDate, endDate));
    }
}
