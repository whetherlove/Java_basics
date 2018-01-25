package java8.stream.staticMethods;

import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.staticMethods
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:24
 * @UpdateDate: 2018/1/25/025 16:24
 */
public class of {

    public static void main(String[] args) {

        //1.receive a series of values
        Stream.of(1,2,3).forEach(System.out::println);

        //2.receive a single element
        //Stream.of(strArray) equals Arrays.stream(strArray)
        String [] strArray = new String[] {"a", "b", "c"};
        System.out.println(Stream.of(strArray).count());

    }
}
