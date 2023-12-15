package Lecture_05;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("2 Groups Hello, world!" + Thread.currentThread() );
    }
}
