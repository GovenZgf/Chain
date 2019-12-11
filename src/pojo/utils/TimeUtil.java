package pojo.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static boolean isTimeOut(Timestamp time){
      String departureTime = time.toString();
      departureTime = departureTime.substring(0,departureTime.indexOf("."));
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime localDateTime = LocalDateTime.parse(departureTime, df);
      return localDateTime.isBefore(LocalDateTime.now());
    };
}
