package Lecture_05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_02 implements Runnable {
//    private int value;
    private final AtomicInteger value;
    private CountDownLatch cdl;

    public int getValue() {
        return value.intValue();
    }

    Task_02(int value) {
        this.value = new AtomicInteger(value);
//        this.value = value;
    }

    public synchronized void inc() {
//        value++;
        value.incrementAndGet();
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown();
    }
}
