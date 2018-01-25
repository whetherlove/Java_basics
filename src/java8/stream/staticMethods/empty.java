package java8.stream.staticMethods;

import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.staticMethods
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 15:13
 * @UpdateDate: 2018/1/25/025 15:13
 */
public class empty {

    public static void main(String[] args) {

        Stream<Integer> a = Stream.of(1,2,3);
        Stream<Integer> b = Stream.empty();

        Stream.concat(a,b).forEach(System.out::print);
    }
}
