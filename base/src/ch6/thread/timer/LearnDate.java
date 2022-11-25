package ch6.thread.timer;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;

public class LearnDate {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_YEAR, 365);
        instance.add(Calendar.MINUTE, 10);
        Date time = instance.getTime();
        System.out.println(time);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 124);
        calendar.setTime(new Date());
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(1998, Calendar.JANUARY, 2, 3, 4, 5);
        Date date = calendar.getTime();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        System.out.println(DayOfWeek.of(firstDayOfWeek));
    }
}
