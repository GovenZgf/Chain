package pojo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TicketUtil {
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            result += random.nextInt(5);
        }
        return newDate + result;
    }
}
