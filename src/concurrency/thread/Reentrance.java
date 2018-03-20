package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 20/03/2018 2:48 PM
 */
public class Reentrance {

    //if a Java thread enters a synchronized block of code, and thereby take the lock on the monitor object the block is synchronized on, the thread can enter other Java code blocks synchronized on the same monitor object. Here is an example:
    //e.g.
    public synchronized void outer(){
        inner();
    }

    public synchronized void inner(){
        //do something
    }

}
