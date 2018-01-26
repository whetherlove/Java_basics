package java8.collectors;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 17:30
 * @UpdateDate: 2018/1/26/026 17:30
 */
public class toMap {

    public static void main(String[] args) {

        //1. toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
        //e.g Map<Student, Double> studentToGPA
        //         students.stream().collect(toMap(Functions.identity(),
        //                                         student -> computeGPA(student)));

        Stream<Integer> s = Stream.of(1,2,2,2,3,3,4);
        Map<Integer,Integer> m = s.distinct().collect(Collectors.toMap(e -> e, e -> e*2));

        m.forEach((k,v) -> System.out.println("key=" + k.toString() + " value" + v.toString()));

        //2. toMap(Function<? super T,? extends K> keyMapper,
        //          Function<? super T,? extends U> valueMapper,
        //          BinaryOperator<U> mergeFunction)
        // 用于解决KEY重复问题
        Stream<Integer> s1 = Stream.of(1,2,2,2,3,3,4);
        Map<Integer,Integer> m1 = s1.collect(Collectors.toMap(e -> e, e -> e*2, (e1,e2) -> e1));
        m1.forEach((k,v) -> System.out.println("key=" + k.toString() + " value" + v.toString()));
        System.out.println(m1 instanceof LinkedHashMap);

        //3.
        //Collector<T,?,M>	toMap(Function<? super T,? extends K> keyMapper,
        //                          Function<? super T,? extends U> valueMapper,
        //                          BinaryOperator<U> mergeFunction,
        //                          Supplier<M> mapSupplier)
        //返回特定map

        Stream<Integer> s2 = Stream.of(1,2,2,2,3,3,4);
        Map m2 = s2.collect(Collectors.toMap(e -> e, e -> e*2, (e1,e2) -> e1, LinkedHashMap::new));
        System.out.println(m2 instanceof LinkedHashMap);


    }
}
