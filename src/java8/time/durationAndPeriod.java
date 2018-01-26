package java8.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @ProjectName: java_basics
 * @Package: java8.time
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 20:32
 * @UpdateDate: 2018/1/26/026 20:32
 */
public class durationAndPeriod {

    public static void main(String[] args) {

        //Duration是用来计算两个给定的日期之间包含多少秒，多少毫秒，它是不可变类且线程安全的
        //Duration中的get方法只会换算到秒，秒为Duration最大单位
        LocalTime localTime = LocalTime.now();
        Duration duration = Duration.between(localTime,localTime.plus(3,ChronoUnit.MINUTES));
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());
        System.out.println(duration.get(ChronoUnit.SECONDS));

        LocalTime localTime1 = LocalTime.now();
        Duration duration1 = Duration.between(localTime1,localTime1.plus(3,ChronoUnit.NANOS));
        System.out.println(duration1.getSeconds());
        System.out.println(duration1.getNano());

        //Period是用来计算两个给定的日期之间包含多少天，多少月或者多少年，它是不可变类且线程安全的
        //Period中的get方法只会换算到年，年为Period最大单位
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(localDate, localDate.plus(3, ChronoUnit.CENTURIES));
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        LocalDate localDate1 = LocalDate.now();
        Period period1 = Period.between(localDate1, localDate1.plus(3, ChronoUnit.DAYS));
        System.out.println(period1.getMonths());
        System.out.println(period1.getDays());

    }
}
