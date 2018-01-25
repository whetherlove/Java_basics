package java8.stream.terminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.terminalOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 15:43
 * @UpdateDate: 2018/1/25/025 15:43
 */
public class forEachAndforEachOrdered {

    public static void main(String[] args) {

        //forEach does not guarantee to respect the encounter order of the stream
        //if required, use forEachOrdered instead
        List<Integer> nums = Arrays.asList(1,null,3,null,4);

        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(Collectors.toList());

        numsWithoutNull.stream().forEach(System.out::print);
    }
}
