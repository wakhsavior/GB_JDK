package Lecture_05;

import java.util.TreeSet;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("1 Groups: Hello, world!" + Thread.currentThread() );
    }
}
