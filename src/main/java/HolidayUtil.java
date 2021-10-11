import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 节假日过滤Util
 */
public class HolidayUtil {

    /**
     * 常规法定节假日
     */
    private static List<String> initHolidayList = Stream.of("01-01", "04-04", "05-01", "05-02", "05-03",
            "10-01", "10-02", "10-03", "10-04", "10-05", "10-06", "10-07").collect(toList());

    /**
     * 农历节假日，春节、中秋，可计算较复杂
     */
    private static List<String> holidayList = new ArrayList<String>() {{
        add("2020-01-24");
        add("2020-01-25");
        add("2020-01-26");
        add("2020-01-27");
        add("2020-01-28");
        add("2020-01-29");
        add("2020-01-30");
        add("2020-06-25");
        add("2020-06-26");
        add("2020-06-27");
        add("2020-10-08");
    }};

    /**
     * 法定调休工作日，数据库维护
     */
    private static List<String> initWorkdayList = new ArrayList<String>() {{
        add("2020-01-19");
        add("2020-04-26");
        add("2020-05-09");
        add("2020-06-28");
        add("2020-09-27");
        add("2020-10-10");
    }};

    private static ThreadLocal<SimpleDateFormat> yyyyMMddFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static SimpleDateFormat yyyyMMdd() {
        return yyyyMMddFormat.get();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getWorkDay("2020-06-38"));
    }

    /**
     * 判断传入日期是否为工作日，如果是则返回该日期，否则返回下一个工作日
     *
     * @param strDate 时间字符串
     * @return
     */
    private static String getWorkDay(String strDate) throws ParseException {
        if (isWeekend(strDate)) {
            if (isWorkDate(strDate)) {
                return strDate;
            } else {
                String nextDay = add(strDate);
                return getWorkDay(nextDay);
            }
        } else {
            if (isHoliday(strDate)) {
                String nextDay = add(strDate);
                return getWorkDay(nextDay);
            } else {
                return strDate;
            }
        }
    }

    private static Boolean isWeekend(String strDate) throws ParseException {
        Date date = yyyyMMdd().parse(strDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
            return true;
        }
        return false;
    }

    private static Boolean isHoliday(String strDate) throws ParseException {
        String s = strDate.substring(5);
        //如果当前日期为"01-01", "05-01", "10-01", "10-02", "10-03", "10-04", "10-05", "10-06", "10-07"
        //则为常规法定节假日
        if (initHolidayList.contains(s)) {
            return true;
        }
        //此处判断一些非常规中的节假日，如春节、中秋或常用法定添加的节假日，建议从数据库维护
        if (holidayList.contains(strDate)) {
            return true;
        }
        return false;
    }

    private static Boolean isWorkDate(String strDate) throws ParseException {
        //如果是国家法定调休工作日
        if (initWorkdayList.contains(strDate)) {
            return true;
        }
        return false;
    }

    /***
     * 传入字符串时间，加1天
     * @param strDate 时间字符串 格式必须是yyyy-MM-dd
     * @return 时间字符串
     */
    public static String add(String strDate) throws ParseException {
        Objects.requireNonNull(strDate);
        Date date = yyyyMMdd().parse(strDate);
        Calendar can = Calendar.getInstance();
        can.setTime(date);
        can.add(5, 1);
        return yyyyMMdd().format(can.getTime());
    }
}
