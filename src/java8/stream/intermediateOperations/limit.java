package java8.stream.intermediateOperations;

import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.intermediateOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:03
 * @UpdateDate: 2018/1/25/025 16:03
 */
public class limit {

    public static void main(String[] args) {

        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }
}
