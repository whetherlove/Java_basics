package java8.collectors;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 17:29
 * @UpdateDate: 2018/1/26/026 17:29
 */
public class summing {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = random
                .ints(1, 100)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        int sum = numbers.stream().collect(Collectors.summingInt(e -> e));
        System.out.println(sum);
    }
}
