package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 20/03/2018 12:40 PM
 */
public class SlippedConditions {

    //Slipped conditions means, that from the time a thread has checked a certain
    //condition until it acts upon it, the condition has been changed by another
    //thread so that it is erroneous for the first thread to act.
    //To avoid slipped conditions the testing and setting of the conditions must be
    //done atomically by the thread doing it, meaning that no other thread can check
    //the condition in between the testing and setting of the condition by the first
    //thread.
    //e.g. bad example
    private boolean isLocked = true;

    public void badLock(){
        synchronized(this){
            while(isLocked){
                try{
                    this.wait();
                } catch(InterruptedException e){
                    //do nothing, keep waiting
                }
            }
        }
        synchronized(this){
            isLocked = true;
        }
    }

    //e.g. better way
    public void betterLock(){
        synchronized(this){
            while(isLocked){
                try{
                    this.wait();
                } catch(InterruptedException e){
                    //do nothing, keep waiting
                }
            }
            isLocked = true;
        }
    }

}
