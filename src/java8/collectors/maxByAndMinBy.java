package java8.collectors;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 13:13
 * @UpdateDate: 2018/1/26/026 13:13
 */
public class maxByAndMinBy {

    public static void main(String[] args) {

        //花式找最小值
         Optional min = Stream.iterate(1, i -> i+1).limit(10)
                .collect(Collectors.maxBy(Comparator.reverseOrder()));

         System.out.println(min.get());
    }
}
