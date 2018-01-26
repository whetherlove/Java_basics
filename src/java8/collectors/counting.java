package java8.collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 10:56
 * @UpdateDate: 2018/1/26/026 10:56
 */
public class counting {

    public static void main(String[] args) {


        //counting returns a long type value
        long size = Stream.iterate(1, i -> i+1).limit(10)
                .collect(Collectors.counting());

        System.out.println(size);
    }
}
