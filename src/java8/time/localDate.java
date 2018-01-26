package java8.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @ProjectName: java_basics
 * @Package: java8.time
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 18:37
 * @UpdateDate: 2018/1/26/026 18:37
 */
public class localDate {

    public static void main(String[] args) {

        //LocalDate只提供日期不提供时间信息。它是不可变类且线程安全的

        //获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("now is:" + today);

        //当前日期所在月有多少天
        System.out.println("The number of days available for this month: " + today.lengthOfMonth());

        //当前日期所在月名称
        System.out.println("What is the month name? : " + today.getMonth().name());

        //推后两天
        System.out.println(today.plus(2, ChronoUnit.DAYS));

        //提前两天
        System.out.println(today.minus(2, ChronoUnit.DAYS));

        //获取年、月、日
        System.out.println("year=" + today.getYear());
        System.out.println("month=" + today.getMonth());
        System.out.println("day=" + today.getDayOfMonth());

        //获取特定日期
        LocalDate dateOfBirth = LocalDate.of(1990,10,12);

        //使用预定格式器解析日期
        String s = "19901012";
        LocalDate date = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);

        //使用自定义格式器
        String s1 = "10 12 1990";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date1 = LocalDate.parse(s1, formatter);
        System.out.println(date1);
    }
}
