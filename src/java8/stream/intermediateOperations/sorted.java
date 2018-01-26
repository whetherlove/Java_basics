package java8.stream.intermediateOperations;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.intermediateOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 21:55
 * @UpdateDate: 2018/1/25/025 21:55
 */
public class sorted {

    public static void main(String[] args) {

        int a[] = {3, 2, 3, 2, 6, 3, 3, 4, 5, 1, 7};

        //1. sort y natural order
        Arrays.stream(a).sorted().forEachOrdered(System.out::println);

        //2. sort with a comparator
        //list.stream().sorted(Comparator.reverseOrder())
        //e.g. list.stream().sorted(Comparator.comparing(Student::getAge).reversed)

    }
}

