package concurrency.thread;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description: There are two ways to specify what code the thread should execute.
 * The first is to create a subclass of Thread and override the run() method. The
 * second method is to pass an object that implements Runnable (java.lang.Runnable
 * to the Thread constructor.
 * @date 19/03/2018 9:50 AM
 */
public class ThreadCreation {

    public static void main(String[] args) {
        //start an instance of MyThread1
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        //start an instance of MyThread2
        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2);
        thread.start();

        //thread can be given a name
        //e.g.
        Thread namedThread1 = new MyThread1("Thread1");
        Thread namedThread2 = new Thread(new MyThread2(),"Thread2");

        //Thread.currentThread()
        //The Thread.currentThread() method returns a reference to the Thread
        //instance executing currentThread().
        System.out.println(Thread.currentThread().getName());
    }
}

//1. extends Thread
class MyThread1 extends Thread{

    public MyThread1() {
    }

    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("my thread1 is running");
    }
}

//2. implements Runnable
class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("my thread2 is running");
    }
}
