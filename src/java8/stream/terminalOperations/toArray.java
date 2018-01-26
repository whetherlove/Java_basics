package java8.stream.terminalOperations;

import java.util.Arrays;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.terminalOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 22:41
 * @UpdateDate: 2018/1/25/025 22:41
 */
public class toArray {

    public static void main(String[] args) {

        //1. Returns an array containing the elements of this stream
        Object[] a = Arrays.asList(1,1,3,4,5,3,2,8).toArray();

        //2. Returns an array containing the elements of this stream,
        //using the provided generator function to allocate the returned
        // array, as well as any additional arrays that might be required
        // for a partitioned execution or for resizing.
        //e.g. Person[] men = people.stream()
        //                          .filter(p -> p.getGender() == MALE)
        //                          .toArray(Person[]::new);

        Integer[] array = Arrays.asList(1,1,3,4,5,3,2,8).stream().toArray(Integer[]::new);
    }
}
