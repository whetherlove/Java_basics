package java8.stream.staticMethods;

import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 14:34
 * @UpdateDate: 2018/1/25/025 14:34
 */
public class builder {

    public static void main(String[] args) {

        //A stream builder has a lifecycle, which starts in a building phase,
        // during which elements can be added, and then transitions to a
        // built phase, after which elements may not be added. The built phase
        // begins when the build() method is called, which creates an ordered
        // Stream whose elements are the elements that were added to the stream
        // builder, in the order they were added.

        System.out.println(
                Stream.builder()
                        .add(1)
                        .add(2)
                        .build()
                        //a stream is built
                        .count()
        );
    }
}
