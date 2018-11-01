import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LocalDate {
    private Calendar calendar;

    LocalDate(int year, int month, int date) {
        calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);
    }

    @Override
    public boolean equals(Object obj) {
        return calendar.equals(obj);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());

    }
}
