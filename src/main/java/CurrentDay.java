import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDay {

    public static String date(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
