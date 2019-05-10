package com.example.springbootmydemo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author benjamin
 * created at 2019/5/8
 */
public class TimeUtils {

    /**
     * 当天
     * 2019-05-08
     * 前一天凌晨
     * 2019-05-07 00:00:00
     *
     * @return 前一天凌晨
     */
    public static long start() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        Date start = calendar.getTime();

        return start.getTime();
    }

    /**
     * 当天 2019-05-08
     * 前一天23:59:59
     * 2019-05-07 23:59:59
     *
     * @return 前一天23:59:59
     */
    public static long end() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        Date end = calendar.getTime();

        return end.getTime();
    }
}
