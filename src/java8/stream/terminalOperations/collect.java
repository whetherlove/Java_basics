package java8.stream.terminalOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 14:36
 * @UpdateDate: 2018/1/25/025 14:36
 */
public class collect {

    public static void main(String[] args) {
        //collect is the only mutable reduction operation using collector
        //This is a terminal operation.

        List<Integer> nums = Arrays.asList(1,null,3,null,4);

        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
        collect(Collectors.toList());

        numsWithoutNull.stream().forEach(System.out::print);

    }
}
