package za.ac.cput.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static String format(LocalDateTime dt){
        if(dt == null) return "";
        return dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}