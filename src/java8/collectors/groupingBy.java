package java8.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 10:57
 * @UpdateDate: 2018/1/26/026 10:57
 */
public class groupingBy {

    public static void main(String[] args) {

        //1. groupingBy(Function<? super T,? extends K> classifier)
        //数据分类
        //e.g Map<String, List<Person>> tempMap =
        // Stream.of(new Person("1", "aa", "12"),
        //           new Person("1", "bb", "13"),
        //           new Person("3", "cc", "14"))
        //                .collect(Collectors.groupingBy(x -> x.id));
        Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4)
                .collect(Collectors.groupingBy(it -> it > 3));
        System.out.println(collectGroup);

        //2. groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        // 分组统计计数
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting())
                );
        System.out.println(result);

        //3. groupingBy(Function<? super T,? extends K> classifier,
        //              Supplier<M> mapFactory,
        //              Collector<? super T,A,D> downstream)
        //
    }
}
