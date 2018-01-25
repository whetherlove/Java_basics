package java8.stream.terminalOperations;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.terminalOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:12
 * @UpdateDate: 2018/1/25/025 16:12
 */
public class noneMatch {

    public static void main(String[] args) {

        int a[] = {1,2,3,3,3,3,3,4,5,6,7};

        System.out.println(Arrays.stream(a).noneMatch(e -> e>10));
    }
}
