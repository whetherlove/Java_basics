package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 10:24 AM
 */
public class ThreadSafe {

    //Code that is safe to call by multiple threads simultaneously is called
    //thread safe. If a piece of code is thread safe, then it contains no race
    //conditions. Race condition only occur when multiple threads update shared
    //resources. Therefore it is important to know what resources Java threads
    //share when executing.

    //1. Local Variables
    //Local variables are stored in each thread's own stack. That means that
    //local variables are never shared between threads. That also means that
    //all local primitive variables are thread safe. Here is an example of a
    //thread safe local primitive variable:
    //e.g.
    public void methodLV(){
        long threadSafeInt = 0;
        threadSafeInt++;
    }

    //2. Local Object References
    //If an object created locally never escapes the method it was created in,
    //it is thread safe. In fact you can also pass it on to other methods and
    //objects as long as none of these methods or objects make the passed object
    //available to other threads.
    //e.g.
    public void methodLOR(){

        Object localObject = new Object();
        localObject.toString();
        methodLOR2(localObject);
    }

    public void methodLOR2(Object localObject){
        int hc = localObject.hashCode();
        System.out.println(hc);
    }
}

class NotSafeThread implements Runnable{
    //3. Object Member Variables
    //if two threads call a method on the same object instance and this method
    //updates object member variables, the method is not thread safe.
    //e.g.
    StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }

    @Override
    public void run() {
        System.out.println(builder);
    }

    public static void main(String[] args) {
        //Object Member Variables examples
        //not thread safe example
        NotSafeThread sharedInstance = new NotSafeThread();
        new Thread(sharedInstance).start();
        new Thread(sharedInstance).start();

        //thread safe example
        new Thread(new NotSafeThread()).start();
        new Thread(new NotSafeThread()).start();
    }
}
