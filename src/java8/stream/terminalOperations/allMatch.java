package java8.stream.terminalOperations;

import java.util.Arrays;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 14:14
 * @UpdateDate: 2018/1/25/025 14:14
 */
public class allMatch {

    public static void main(String[] args) {

        int a[] = {1,2,3,3,3,3,3,4,5,6,7};

        //allMatch is a terminal operation
        System.out.println(Arrays.stream(a).allMatch(e -> e==3));
        System.out.println(Arrays.stream(a).allMatch(e -> e>0));
    }
}
