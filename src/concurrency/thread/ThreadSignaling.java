package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 12:14 PM
 */
public class ThreadSignaling {

    //The purpose of thread signaling is to enable threads to send signals to each
    //other. Additionally, thread signaling enables threads to wait for signals from
    //other threads. For instance, a thread B might wait for a signal from thread A
    //indicating that data is ready to be processed.

    //Signaling via Shared Objects
    //A simple way for threads to send signals to each other is by setting the signal
    //values in some shared object variable. Thread A may set the boolean member variable
    //hasDataToProcess to true from inside a synchronized block, and thread B may read
    //the hasDataToProcess member variable, also inside a synchronized block.
    //e.g.
    protected boolean hasDataToProcess = false;   //shared

    public synchronized boolean hasDataToProcess() {
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasData) {
        this.hasDataToProcess = hasData;
    }
}
//Busy Wait
//while(!sharedSignal.hasDataToProcess()){
//do nothing... busy waiting
//Notice how the while loop keeps executing until hasDataToProcess() returns true.
//This is called busy waiting. The thread is busy while waiting.
//Busy waiting is not a very efficient utilization of the CPU in the computer running
//the waiting thread, except if the average waiting time is very small. Else, it would
//be smarter if the waiting thread could somehow sleep or become inactive until it
//receives the signal it is waiting for.

//Resolve busy waiting
//Java has a builtin wait mechanism that enable threads to become inactive while waiting
//for signals. The class java.lang.Object defines three methods, wait(), notify(), and
//notifyAll(), to facilitate this.
//e.g.
class MonitorObject {
}

class MyWaitNotify {

    MonitorObject myMonitorObject = new MonitorObject();

    public void doWait() {
        synchronized (myMonitorObject) {
            try {
                myMonitorObject.wait();
            } catch (InterruptedException e) {}
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            myMonitorObject.notify();
        }
    }
}

//Missed Signals
//if a thread calls notify() before the thread to signal has called wait(), the signal
//will be missed by the waiting thread, to avoid these situation, store the signal
//status in a variable
//e.g.
class MyWaitNotify2 {

    MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait() {
        synchronized (myMonitorObject) {
            if (!wasSignalled) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {}
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
}

//Spurious Wakeups
//For inexplicable reasons it is possible for threads to wake up even if notify() and
//notifyAll() has not been called. This is known as spurious wakeups. Wakeups without
//any reason.
//to resolve this, nest signal member variable check inside a while loop instead of
//inside an if-statement.
//e.g.
class MyWaitNotify3{

    MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait(){
        synchronized(myMonitorObject){
            while(!wasSignalled){
                try{
                    myMonitorObject.wait();
                } catch(InterruptedException e){}
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    public void doNotify(){
        synchronized(myMonitorObject){
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
}
//The while loop is also a nice solution if you have multiple threads waiting, which
//are all awakened using notifyAll(), but only one of them should be allowed to continue.

//Note: Don't call wait() on constant String's or global objects because they may be shared
//among different MyWaitNotify instances rather than threads from the same MyWaitNotify
//instances


