package java8.collectors;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 13:29
 * @UpdateDate: 2018/1/26/026 13:29
 */
public class partitioningBy {

    public static void main(String[] args) {

        //1. partitioningBy(Predicate<? super T> predicate)
        Map<Boolean,List<Integer>> a = Stream.iterate(1, i -> i+1).limit(10)
                .collect(Collectors.partitioningBy(i -> Integer.valueOf(i)>3));

        a.forEach((b,l) -> System.out.println(l.size()));

        //2. partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
        //分类后求平均值
        Object b = Stream.iterate(1, i -> i+1).limit(10).collect(Collectors
                .partitioningBy(i -> Integer.valueOf(i)>3,Collectors.averagingDouble(e -> e.doubleValue())));

        System.out.println(b.toString());
    }
}
