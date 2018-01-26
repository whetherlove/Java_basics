package java8.stream.terminalOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @ProjectName: java_basics
 * @Package: java8.stream.terminalOperations
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 16:42
 * @UpdateDate: 2018/1/25/025 16:42
 */
public class reduce {

    public static void main(String[] args) {

        //reduce操作可以实现从Stream中根据指定的计算模型生成一个值，
        //count、min和max方法，因为常用而被纳入标准库中。
        //事实上，这些方法都是reduce操作。

        int a[] = {1,2,3,4,5};

        //1. acc = a[0] item = a[1] 返回optional值
        // reduce(BinaryOperator<T> accumulator)
        int sum = Arrays.stream(a)
                .reduce((acc,item) -> {
                            acc += item;
                            return acc;
                })
                .getAsInt();
        System.out.println(sum);

        //2. acc = 0 item = a[0] 返回identity类型值
        //reduce(T identity, BinaryOperator<T> accumulator)
        int sum2 = Arrays.stream(a)
                .reduce(0, (acc,item) -> {
                    acc += item;
                    return acc;
                });

        System.out.println(sum2);

        //3. can be replaced by map+reduce
        //reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)

        //Bifunction<input1type,input2type,outputtype> 接受2个参数返回一个参数
        BiFunction<ArrayList<Integer>,Integer,ArrayList<Integer>> biFunction =
                (acc,item) -> {acc.add(item); return acc;};
        //BinaryOperator继承了Bifunction，其接收的两个参数与返回的参数均为同一类型
        BinaryOperator<ArrayList<Integer>> binaryOperator =
                (acc,item) -> {acc.addAll(item); return acc;};

        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
                .reduce(new ArrayList<Integer>(),
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {
                                acc.add(item);
                                return acc;
                            }
                        },
                        //此处combiner并未执行。其原因是Stream是支持并发操作的，
                        // 为了避免竞争，对于reduce线程都会有独立的result，
                        //combiner的作用在于合并每个线程的result得到最终结果。
                        new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
                                acc.addAll(item);
                                return acc;
                            }
                        });
        accResult_.stream().forEach(System.out::println);
    }
}
