package java8.time;

import java.time.LocalDateTime;

/**
 * @ProjectName: java_basics
 * @Package: java8.time
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 20:50
 * @UpdateDate: 2018/1/26/026 20:50
 */
public class localDateTime {

    public static void main(String[] args) {

        //LocalDate 和LocalTime 合体
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //获取某一时间单位数值
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMonth());
    }
}
