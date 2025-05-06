package top.sp817.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends Calendar {

    public static String NowCheck() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.ffffff");
        return now.format(formatter);
    }



    public static Date getTomorrow() {
        // 获取当前时间的Calendar实例
        Calendar calendar = Calendar.getInstance();

        // 在当前时间上加上一天
        calendar.add(Calendar.DATE, 1);

        // 将时间设置为0点0分
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 从Calendar实例获取Date对象
        return (calendar.getTime());
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化Date对象
        String formattedDate = sdf.format(getTomorrow());

        // 输出格式化后的日期和时间
        System.out.println(formattedDate);
    }

    /** Calendar **/
    public static Date alt(Date date, int field, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, num);
        return calendar.getTime();
    }

    @Override
    protected void computeTime() {

    }

    @Override
    protected void computeFields() {

    }

    @Override
    public void add(int field, int amount) {

    }

    @Override
    public void roll(int field, boolean up) {

    }

    @Override
    public int getMinimum(int field) {
        return 0;
    }

    @Override
    public int getMaximum(int field) {
        return 0;
    }

    @Override
    public int getGreatestMinimum(int field) {
        return 0;
    }

    @Override
    public int getLeastMaximum(int field) {
        return 0;
    }
}
