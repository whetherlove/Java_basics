package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 20/03/2018 12:37 PM
 */
public class NestedMonitorLockout {

    //e.g.
//    Thread 1 synchronizes on A
//    Thread 1 synchronizes on B (while synchronized on A)
//    Thread 1 decides to wait for a signal from another thread before continuing
//    Thread 1 calls B.wait() thereby releasing the lock on B, but not A.
//
//    Thread 2 needs to lock both A and B (in that sequence)
//    to send Thread 1 the signal.
//    Thread 2 cannot lock A, since Thread 1 still holds the lock on A.
//    Thread 2 remain blocked indefinately waiting for Thread1
//    to release the lock on A
//
//    Thread 1 remain blocked indefinately waiting for the signal from
//    Thread 2, thereby
//    never releasing the lock on A, that must be released to make
//    it possible for Thread 2 to send the signal to Thread 1, etc.

    //sum up:
    //In deadlock, two threads are waiting for each other to release locks.
    //In nested monitor lockout, Thread 1 is holding a lock A, and waits
    //for a signal from Thread 2. Thread 2 needs the lock A to send the
    //signal to Thread 1.

    //Tips: Try not to nest synchronized code.
}
