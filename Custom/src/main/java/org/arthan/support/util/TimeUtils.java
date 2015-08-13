package org.arthan.support.util;

/**
 * Created by Артур on 12.08.2015.
 * Next to Ufa.
 */
public class TimeUtils {
    public static String intervalToString(long timeInterval) {
        if(timeInterval < 1_000)
            return "less than one second";
        if(timeInterval < 60_000)
            return (timeInterval / 1_000) + " seconds";
        return "about " + (timeInterval / 60_000) + " minutes";
    }
}
