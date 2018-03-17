package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 16/03/2018 8:05 PM
 */
public class PathAndPaths {

    public static void main(String[] args) {

        Path path = Paths.get("nio-data.txt");

        //The following two arguments are of the same function
        Path data = Paths.get("/Users/jacobzhang/Documents/java_basics/nio-data.txt");
        Path data1 = Paths.get("/Users","jacobzhang","Documents/java_basics","nio-data.txt");
        System.out.println("data= " + data);
        System.out.println("data1= " + data1);

        //. as a parameter
        Path currentDir = Paths.get(".");
        System.out.println("currentDir= " + currentDir.toAbsolutePath());

        //..
        Path parentDir = Paths.get("../..");
        System.out.println("parentDir= " + parentDir.toAbsolutePath());

        //Path normalize()
        //The normalize() method of the Path interface can normalize a path.
        //Normalizing means that it removes all the . and .. codes in the middle
        //of the path string, and resolves what path the path string refers to.
        String pathStr = "/Users/jacobzhang/Documents/java_basics/../java_basics/nio-data.txt";
        Path p1 = Paths.get(pathStr);
        System.out.println("p1= " + p1);
        Path p2 = p1.normalize();
        System.out.println("p2= " + p2);

    }
}
