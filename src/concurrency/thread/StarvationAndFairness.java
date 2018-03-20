package concurrency.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 20/03/2018 11:16 AM
 */
public class StarvationAndFairness {

    //If a thread is not granted CPU time because other threads grab it all,
    //it is called "starvation". The thread is "starved to death" because other
    //threads are allowed the CPU time instead of it. The solution to starvation
    //is called "fairness" - that all threads are fairly granted a chance to execute.

    //Causes of Starvation in Java
    //1. Threads with high priority swallow all CPU time from threads with lower priority.
    //2. Threads are blocked indefinately waiting to enter a synchronized block,
    //because other threads are constantly allowed access before it.
    //3. Threads waiting on an object (called wait() on it) remain waiting indefinitely
    //because other threads are constantly awakened instead of it.
}

//If more than one thread call a synchronized method, some of them will be blocked
//until the first thread granted access has left the method. If more than one thread
//are blocked waiting for access there is no guarantee about which thread is granted
//access next.
//Instead of using synchronized, use a customized Lock and queue up threads is a
//way to achieve fairness
//e.g.
class Synchronizer{
    FairLock lock = new FairLock();

    public void doSynchronized() throws InterruptedException{
        this.lock.lock();
        //critical section, do a lot of work which takes a long time
        this.lock.unlock();
    }

}
class FairLock {
    private boolean           isLocked       = false;
    private Thread            lockingThread  = null;
    private List<QueueObject> waitingThreads =
            new ArrayList<>();

    public void lock() throws InterruptedException{
        QueueObject queueObject           = new QueueObject();
        boolean     isLockedForThisThread = true;
        synchronized(this){
            waitingThreads.add(queueObject);
        }

        while(isLockedForThisThread){
            synchronized(this){
                isLockedForThisThread =
                        isLocked || waitingThreads.get(0) != queueObject;
                if(!isLockedForThisThread){
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try{
                queueObject.doWait();
            }catch(InterruptedException e){
                synchronized(this) { waitingThreads.remove(queueObject); }
                throw e;
            }
        }
    }

    public synchronized void unlock(){
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked      = false;
        lockingThread = null;
        if(waitingThreads.size() > 0){
            waitingThreads.get(0).doNotify();
        }
    }
}
class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while(!isNotified){
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }
}
