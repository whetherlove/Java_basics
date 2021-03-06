package java8.stream.staticMethods;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.staticMethods
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 15:48
 * @UpdateDate: 2018/1/25/025 15:48
 */
public class generate {

    public static void main(String[] args) {

        //Returns an infinite sequential unordered stream where each
        //element is generated by the provided Supplier. This is suitable
        //for generating constant streams, streams of random elements, etc.


        Stream.generate(new Supplier<Double>() {
	        @Override
	        public Double get() {
	            return Math.random();
	        }
	    });

        Stream.generate(() -> Math.random());

        Stream.generate(Math::random);
    }
}
