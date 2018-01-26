package java8.time;

import java.time.Clock;

/**
 * @ProjectName: java_basics
 * @Package: java8.time
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 20:29
 * @UpdateDate: 2018/1/26/026 20:29
 */
public class clock {

    public static void main(String[] args) throws InterruptedException {

        //clock可以用来获取某个时区下（所以对时区是敏感的）当前的瞬时时间、日期。
        // 用来代替System.currentTimelnMillis()与TimeZone.getDefault()方法。

        Clock clock = Clock.systemUTC();
        System.out.println(clock);

        long startTime = clock.millis();
        Thread.sleep(1200);
        long endTime = clock.millis();
        System.out.println(endTime - startTime);
    }
}
