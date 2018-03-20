package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 10:50 AM
 */
public class Synchronized {

    //A synchronized block in Java is synchronized on some object. All synchronized
    //blocks synchronized on the same object can only have one thread executing
    //inside them at the same time. All other threads attempting to enter the
    //synchronized block are blocked until the thread inside the synchronized block
    //exits the block.

    private int count;
    private static int sum;

    //1. Synchronized Instance Methods
    public synchronized void add(int value){
        this.count += value;
    }

    //2. Synchronized Static Methods
    public static synchronized void addSum(int value){
        sum += value;
    }

    //3. Synchronized Blocks in Instance Methods
    //the following code is equivalent to add
    public void add2(int value){
        synchronized(this){
            this.count += value;
        }
    }

    //4.Synchronized Blocks in Static Methods
    //the following code is equivalent to addSum
    public static void addSum2(int value){
        synchronized (Synchronized.class) {
            sum += value;
        }
    }

    //Tips:
    //for larger critical sections it may be beneficial to break the critical
    //section into smaller critical sections, to allow multiple threads to execute
    //each a smaller critical section. This may decrease contention on the shared
    //resource, and thus increase throughput of the total critical section.
    //e.g.
    private int sum1 = 0;
    private int sum2 = 0;
    //a bad way
    public void badAdd(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;
            this.sum2 += val2;
        }
    }
    //a better way
    private Integer sum1Lock = new Integer(1);
    private Integer sum2Lock = new Integer(2);

    public void goodAdd(int val1, int val2){
        synchronized(this.sum1Lock){
            this.sum1 += val1;
        }
        synchronized(this.sum2Lock){
            this.sum2 += val2;
        }
    }

}
