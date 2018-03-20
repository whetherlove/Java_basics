package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 10:15 AM
 */
public class RaceConditions {

    //A race condition is a special condition that may occur inside a critical
    //section. A critical section is a section of code that is executed by multiple
    //threads and where the sequence of execution for the threads makes a difference
    //in the result of the concurrent execution of the critical section.

}

//critical section Java code example
class Counter {

    protected long count = 0;

    public void add(long value){
        this.count = this.count + value;
    }
}
//Imagine if two threads, A and B, are executing the add method on the same
//instance of the Counter class.
//   this.count = 0;
//   A:  Reads this.count into a register (0)
//   B:  Reads this.count into a register (0)
//   B:  Adds value 2 to register
//   B:  Writes register value (2) back to memory. this.count now equals 2
//   A:  Adds value 3 to register
//   A:  Writes register value (3) back to memory. this.count now equals 3
//   ideal result: count = 5, actual result: count = 3