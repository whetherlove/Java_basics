package java8.stream.staticMethods;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.intermediateOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 15:03
 * @UpdateDate: 2018/1/25/025 15:03
 */
public class concat {
    public static void main(String[] args) {

        Stream<Integer> a = Stream.of(1,2,3);
        Stream<Integer> b = Stream.of(2,3,4);

        long numOfThree = Stream.concat(a,b)
                .filter(e -> e==3).count();

        System.out.println(numOfThree);
    }
}
