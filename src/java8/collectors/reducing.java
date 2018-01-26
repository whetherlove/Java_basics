package java8.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 17:14
 * @UpdateDate: 2018/1/26/026 17:14
 */
public class reducing {

    public static void main(String[] args) {

        int a[] = {1,2,3,3,3,3,3,4,5,6,7};

        //1. reducing(BinaryOperator<T> op)
        //given a stream of Person, to calculate tallest person in each city
        // Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);
        // Map<City, Person> tallestByCity = people.stream()
        // .collect(groupingBy(Person::getCity, reducing(BinaryOperator.maxBy(byHeight))));
        Stream<Integer> s = Stream.of(5, 10, 20, 50);
        Integer i = s.collect(Collectors.reducing((integer, integer2) -> integer2 - integer))
                .orElse(-1);

        System.out.println(i);

        //2. reducing(T identity, BinaryOperator<T> op)
        Stream<Integer> s2 = Stream.of(5, 10, 20, 50);
        Integer j = s2.collect(Collectors.reducing(0,(integer, integer2) -> integer2 - integer));
        System.out.println(j);

        //3. reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        //quite like reduce in stream
    }
}
