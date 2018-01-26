package java8.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
public class toCollectionListSet {

    public static void main(String[] args) {

        //toCollection转成特定集合
        TreeSet<Integer> collect = Stream.of(1, 2,3, 4).collect(Collectors.toCollection(TreeSet::new));
        collect.stream().forEach(System.out::print);

        //toList
        List<Integer> list =  Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        list.stream().forEach(System.out::print);

        //toSet
        Set<Integer> set = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());
        set.stream().forEach(System.out::print);
    }
}
