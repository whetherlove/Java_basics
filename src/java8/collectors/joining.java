package java8.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: java_basics
 * @Package: java8.collectors
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 12:34
 * @UpdateDate: 2018/1/26/026 12:34
 */
public class joining {

    public static void main(String[] args) {

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        //1. 连接字符串
        String a = items.stream().collect(Collectors.joining());

        //2.指定分隔符
        String b = items.stream().collect(Collectors.joining(","));

        //3.加入制定前后缀
        String c = items.stream().collect(Collectors
                .joining(" and ","I love "," so much!!!"));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


    }
}
