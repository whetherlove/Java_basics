package java8.collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 10:45
 * @UpdateDate: 2018/1/26/026 10:45
 */
public class collectingAndThen {

    public static void main(String[] args) {

        //collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)
        //Adapts a Collector to perform an additional finishing transformation

        int size = Stream.iterate(1, i -> i+1).limit(10)
                .collect(Collectors.collectingAndThen(toList(), List::size));

        System.out.println(size);
    }
}
