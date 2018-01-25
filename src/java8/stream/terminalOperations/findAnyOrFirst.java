package java8.stream.terminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.terminalOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 15:28
 * @UpdateDate: 2018/1/25/025 15:28
 */
public class findAnyOrFirst {

    public static void main(String[] args) {

        //The behavior of this operation is explicitly nondeterministic;
        // it is free to select any element in the stream. This is to allow
        // for maximal performance in parallel operations; the cost is that
        // multiple invocations on the same source may not return the same result.
        // (If a stable result is desired, use findFirst() instead.)
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list
                .stream().parallel()
                .filter(num -> num < 4).findAny();
    }
}
