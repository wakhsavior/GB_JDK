package Lecture_05;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello, World!");
//        System.out.println(Thread.currentThread().getName());
//        for (int i=0;i<3;i++){
//            new MyThread().start();
//        }
//        for (int i=0;i<5;i++){
//            new Thread(new MyRunnable()).start();
//        }
//        for (int i=0;i<5;i++){
//            new Thread(()->{System.out.println("3 Groups Hello, world!" + Thread.currentThread() );}).start();
//        }
        TikTak ticTac_1 = new TikTak("1",0);
        TikTak ticTac_2 = new TikTak("2",1);
        TikTak ticTac_3 = new TikTak("3",2);
        Thread tic = new Thread(ticTac_1);
        Thread tac = new Thread(ticTac_2);
        Thread toe = new Thread(ticTac_3);

//        tic.setDaemon(true);
//        tac.setDaemon(true);
        tic.start();
        toe.start();
        tac.start();
//        long start = System.currentTimeMillis();
//        Task_02 task = new Task_02(0);
//
//        CountDownLatch cdl = new CountDownLatch(3);
//        task.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
//
//        }
//        cdl.await();
//        System.out.println(task.getValue());
//        long end  = System.currentTimeMillis();
//        System.out.println("Time: " + (end - start) + "msec");
    }
}
