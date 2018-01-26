package java8.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 12:45
 * @UpdateDate: 2018/1/26/026 12:45
 */
public class mapping {

    public static void main(String[] args) {

        //mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)
        //e.g to accumulate the set of last names in each city
        // Map<City, Set<String>> lastNamesByCity = people.stream().collect(
        //          groupingBy(Person::getCity,
        //          mapping(Person::getLastName, toSet())));
        //
        //collect(mapping) can be replaced by map().collect()
        Object[] a = Stream.iterate(1, i -> i+1).limit(10)
                .collect(Collectors.mapping(e -> e+2,toList())).toArray();

        for (Object o : a)
            System.out.println(o.toString());
    }
}
