package java8.stream.intermediateOperations;

import java.util.Arrays;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.intermediateOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 17:23
 * @UpdateDate: 2018/1/25/025 17:23
 */
public class skip {

    public static void main(String[] args) {

        int a[] = {1,2,3,3,3,3,3,4,5,6,7};

        Arrays.stream(a).skip(4).forEach(System.out::println);
    }
}
