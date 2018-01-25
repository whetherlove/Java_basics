package java8.stream.intermediateOperations;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.intermediateOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 15:31
 * @UpdateDate: 2018/1/25/025 15:31
 */
public class flatMap {

    public static void main(String[] args) throws Exception{

        //The flatMap() operation has the effect of applying
        // a one-to-many transformation to the elements of the
        // stream, and then flattening the resulting elements
        // into a new stream.

        //If path is the path to a file, then the following produces
        // a stream of the words contained in that file:

        Stream<String> lines = Files.lines(Paths.get("flatMap.txt"), StandardCharsets.UTF_8);
        Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));

    }
}
