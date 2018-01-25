package java8.stream.intermediateOperations;

import java.util.Arrays;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.intermediateOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:35
 * @UpdateDate: 2018/1/25/025 16:35
 */
public class peek {

    public static void main(String[] args) {

        int a[] = {1,2,3,3,3,3,3,4,5,6,7};

        //Returns a stream consisting of the elements of this stream,
        // additionally performing the provided action on each element

        // !!!!!! as elements are consumed from the resulting stream.!!!!!
        //

        Arrays.stream(a).peek(System.out::print).forEach(e -> System.out.print("a"));
    }
}
