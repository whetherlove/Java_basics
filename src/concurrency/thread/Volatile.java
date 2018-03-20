package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 11:01 AM
 */
public class Volatile {

    //The Java volatile keyword is used to mark a Java variable as
    //"being stored in main memory" rather than any CPU cache.

    //Variable Visibility Problems
    //In a multithreaded application where the threads operate on non-volatile variables,
    //each thread may copy variables from main memory into a CPU cache while working on
    //them, for performance reasons.
    //Imagine a situation in which two or more threads have access to a shared object
    //which contains a counter variable declared like this:
    public int counter = 0;
    //Imagine too, that only Thread 1 increments the counter variable, but both Thread 1
    //and Thread 2 may read the counter variable from time to time.
    //If the counter variable is not declared volatile there is no guarantee about when
    //the value of the counter variable is written from the CPU cache back to main memory.
    //This means, that the counter variable value in the CPU cache may not be the same
    //as in main memory.
    //The problem with threads not seeing the latest value of a variable because it has
    //not yet been written back to main memory by another thread, is called a "visibility"
    //problem. The updates of one thread are not visible to other threads.

    //The Java volatile keyword is intended to address variable visibility problems.
    //By declaring the counter variable volatile all writes to the counter variable
    //will be written back to main memory immediately. Also, all reads of the counter
    //variable will be read directly from main memory.
    public volatile int anotherCounter = 0;

    //Full volatile Visibility Guarantee
    //the visibility guarantee of Java volatile goes beyond the volatile variable itself.
    //The visibility guarantee is as follows:
    //If Thread A writes to a volatile variable and Thread B subsequently reads the same
    //volatile variable, then all variables visible to Thread A before writing the volatile
    //variable, will also be visible to Thread B after it has read the volatile variable.
    //If Thread A reads a volatile variable, then all all variables visible to Thread A
    //when reading the volatile variable will also be re-read from main memory.
    //e.g.
    private int years;
    private int months;
    private volatile int days;
    //e.g. write
    //The update() method writes three variables, of which only days is volatile.
    public void update(int years, int months, int days){
        this.years  = years;
        this.months = months;
        this.days   = days;
    }
    //when a value is written to days, the values of years and months are also written to
    //main memory.

    //e.g. read
    //the totalDays() method starts by reading the value of days into the total variable.
    //When reading the value of days, the values of months and years are also read into
    //main memory. Therefore you are guaranteed to see the latest values of days, months
    //and years with the above read sequence.
    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    //Instruction Reordering Challenges
    //The Java VM and the CPU are allowed to reorder instructions in the program for
    //performance reasons, as long as the semantic meaning of the instructions remain
    //the same
    //e.g
    //int a = 1;                int a = 1;
    //int b = 2;    Reorder     a++;
    //a++;                      int b = 2;
    //b++;                      b++;
    //However, instruction reordering present a challenge when one of the variables is
    //a volatile variable.
    //e.g.
    public void update2(int years, int months, int days){
        this.days   = days;
        this.months = months;
        this.years  = years;
    }
    //The values of months and years are still written to main memory when the days
    //variable is modified, but this time it happens before the new values have been
    //written to months and years. The new values are thus not properly made visible
    //to other threads. The semantic meaning of the reordered instructions has changed.

    //The Java volatile Happens-Before Guarantee prevent JVM to reorder volatile variable
}
