package java8.stream.terminalOperations;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.terminalOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:05
 * @UpdateDate: 2018/1/25/025 16:05
 */
public class maxAndMin {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7};

        int max = Arrays.stream(a).max().getAsInt();

        System.out.println(Arrays.stream(a).min().getAsInt());
    }

}
