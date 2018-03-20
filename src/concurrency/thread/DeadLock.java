package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 20/03/2018 10:45 AM
 */
public class DeadLock {

    //Thread Deadlock
    //e.g.1
    //Thread 1  locks A, waits for B
    //Thread 2  locks B, waits for A
    //Thread 1 and 2 waiting forever
    //e.g.2
    //Thread 1  locks A, waits for B
    //Thread 2  locks B, waits for C
    //Thread 3  locks C, waits for D
    //Thread 4  locks D, waits for A

    //Database Deadlocks
    //e.g.
    //Transaction 1, request 1, locks record 1 for update
    //Transaction 2, request 1, locks record 2 for update
    //Transaction 1, request 2, tries to lock record 2 for update.
    //Transaction 2, request 2, tries to lock record 1 for update.

    //DeadLock prevention

    //1. Lock ordering
    //Deadlock occurs when multiple threads need the same locks but obtain
    //them in different order.
    //If you make sure that all locks are always taken in the same order by
    //any thread, deadlocks cannot occur.
    //e.g.

    //Thread 1:
    //lock A
    //lock B

    //Thread 2:
    //wait for A
    //lock C (when A locked)

    //Thread 3:
    //wait for A
    //wait for B
    //wait for C

    //If a thread, like Thread 3, needs several locks, it must take them in the
    //decided order. It cannot take a lock later in the sequence until it has
    //obtained the earlier locks.
    //For instance, neither Thread 2 or Thread 3 can lock C until they have
    //locked A first. Since Thread 1 holds lock A, Thread 2 and 3 must first
    //wait until lock A is unlocked. Then they must succeed in locking A, before
    //they can attempt to lock B or C.
    //Note: Lock ordering is a simple yet effective deadlock prevention mechanism.
    //However, it can only be used if you know about all locks needed ahead of
    //taking any of the locks.

    //2. Lock Timeout
    //put a timeout on lock attempts meaning a thread trying to obtain a lock will
    //only try for so long before giving up. If a thread does not succeed in taking
    //all necessary locks within the given timeout, it will backup, free all locks
    //taken, wait for a random amount of time and then retry.
    //Note: A problem with the lock timeout mechanism is that it is not possible to
    //set a timeout for entering a synchronized block in Java.
    //to address this problem, refer to java.util.concurrency

    //3.
    //Every time a thread takes a lock it is noted in a data structure (map, graph etc.)
    //of threads and locks. Additionally, whenever a thread requests a lock this is also
    //noted in this data structure.
    //When a thread requests a lock but the request is denied, the thread can traverse
    //the lock graph to check for deadlocks.
    //So what do the threads do if a deadlock is detected?
    //One possible action is to release all locks, backup, wait a random amount of
    //time and then retry.
    //A better option is to determine or assign a priority of the threads so that only one
    //(or a few) thread backs up. The rest of the threads continue taking the locks they
    //need as if no deadlock had occurred.



}
