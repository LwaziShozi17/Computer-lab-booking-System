package za.ac.cput.util;

import java.util.concurrent.atomic.AtomicLong;

public class Helper {
    private static final AtomicLong COUNTER = new AtomicLong(1000);

    public static Long generateId(){
        return COUNTER.getAndIncrement();
    }
}