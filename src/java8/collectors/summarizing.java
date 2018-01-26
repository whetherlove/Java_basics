package java8.collectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 17:29
 * @UpdateDate: 2018/1/26/026 17:29
 */
public class summarizing {

    public static void main(String[] args) {

        //summarizingDouble(ToDoubleFunction<? super T> mapper)
        // Returns a Collector which applies an double-producing
        // mapping function to each input element, and returns
        // summary statistics for the resulting values.

        Random random = new Random();
        List<Integer> numbers = random
                .ints(1, 100)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        IntSummaryStatistics r = numbers.stream().collect(Collectors.summarizingInt(x -> x*2));

        System.out.println(r);



    }
}
