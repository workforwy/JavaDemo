import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    private static void tryit(int Y, int M, int D, String pat) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pat);
        LocalDate dat = LocalDate.of(Y, M, D);
        String str = fmt.format(dat);
        System.out.printf("Y=%04d M=%02d D=%02d " +
                "formatted with " +
                "\"%s\" -> %s\n", Y, M, D, pat, str);
    }

    public static void main(String[] args) {
        tryit(2020, 01, 20, "MM/DD/YYYY");
        tryit(2020, 01, 21, "DD/MM/YYYY");
        tryit(2020, 01, 22, "YYYY-MM-DD");
        tryit(2020, 03, 17, "MM/DD/YYYY");
        tryit(2020, 03, 18, "DD/MM/YYYY");
        tryit(2020, 03, 19, "YYYY-MM-DD");
    }
}