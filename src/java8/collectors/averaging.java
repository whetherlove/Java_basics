package java8.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.collector
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 10:35
 * @UpdateDate: 2018/1/26/026 10:35
 */
public class averaging {

    public static void main(String[] args) {

        //there are three types of averaging. averagingDouble,averagingInt,averagingLong

        //averagingDouble(ToDoubleFunction<? super T> mapper)
        double avg = Stream.iterate(1, i -> i+1).limit(10)
                .collect(Collectors.averagingDouble(e -> e));

        System.out.println(avg);

    }
}
