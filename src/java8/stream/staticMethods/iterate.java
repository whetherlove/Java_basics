package java8.stream.staticMethods;

import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.staticMethods
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:00
 * @UpdateDate: 2018/1/25/025 16:00
 */
public class iterate {

    public static void main(String[] args) {

        //Returns an infinite sequential ordered Stream produced by
        //iterative application of a function f to an initial element
        //seed, producing a Stream consisting of seed, f(seed), f(f(seed)), etc.

        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }
}
