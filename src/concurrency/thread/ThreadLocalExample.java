package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 11:55 AM
 */
public class ThreadLocalExample {

    //The ThreadLocal class in Java enables you to create variables that can only
    //be read and written by the same thread. Thus, even if two threads are executing
    //the same code, and the code has a reference to a ThreadLocal variable, then the
    //two threads cannot see each other's ThreadLocal variables.

    //Creating a ThreadLocal
    private ThreadLocal myThreadLocal = new ThreadLocal();
    //This only needs to be done once per thread. Even if different threads execute
    //the same code which accesses a ThreadLococal, each thread will see only its own
    //ThreadLocal instance. Even if two different threads set different values on the
    //same ThreadLocal object, they cannot see each other's values.

    //Accessing a ThreadLocal
    public void setAndGet() {
        myThreadLocal.set("A thread local value");
        String threadLocalValue = (String) myThreadLocal.get();
    }

    //Generic ThreadLocal
    //create a generic ThreadLocal so that you do not have to typecast the value
    //returned by get().
    private ThreadLocal<String> myThreadLocal2 = new ThreadLocal<>();
    public void setAndGet2() {
    myThreadLocal2.set("Hello ThreadLocal");
    String threadLocalValue2 = myThreadLocal2.get();
    }

    //Since values set on a ThreadLocal object only are visible to the thread who set
    //the value, no thread can set an initial value on a ThreadLocal using set() which
    //is visible to all threads. Instead:
    private ThreadLocal threadLocal = ThreadLocal.withInitial(() -> "This is the initial value");

    //a full example
    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance,"t1");
        Thread thread2 = new Thread(sharedRunnableInstance,"t2");

        thread1.start();
        thread2.start();

    }

    //InheritableThreadLocal
    //The InheritableThreadLocal class is a subclass of ThreadLocal. Instead of each
    //thread having its own value inside a ThreadLocal, the InheritableThreadLocal
    //grants access to values to a thread and all child threads created by that thread.
}

