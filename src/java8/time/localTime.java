package java8.time;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @ProjectName: java_basics
 * @Package: java8.time
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 20:23
 * @UpdateDate: 2018/1/26/026 20:23
 */
public class localTime {

    public static void main(String[] args) {

        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //获取小时信息
        System.out.println("The hour of the day: " + localTime.getHour());

        //增加某一时长
        System.out.println(localTime.plus(15, ChronoUnit.MINUTES));
        System.out.println(localTime.plusMinutes(15));

        //制定特定时间
        LocalTime t = LocalTime.of(21,34,56);
    }
}
