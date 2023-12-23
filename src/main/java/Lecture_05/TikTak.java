package Lecture_05;

public class TikTak implements Runnable {
    private final String bracket;
    private final Object monitor;
    static int curThread = 0;
    final int threadNum;
    static int numberOfThreads = 3;

    public TikTak(String bracket, int num) {
        this.bracket = bracket;
        this.monitor = TikTak.class;
        this.threadNum = num;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {

                try {
                    if (threadNum != curThread) {
                        monitor.notify();
                        monitor.wait();
                    } else {
                        System.out.print(bracket);
                        Thread.sleep(300);
                        monitor.notify();
                        monitor.wait();
                        curThread = (curThread+1)%numberOfThreads;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
