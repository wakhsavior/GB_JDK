package Lecture_05;

public class Main {
    public static void main(String[] args) {
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
        Thread tic = new Thread(new TikTak("["));
        Thread tac = new Thread(new TikTak("]"));
//        tic.setDaemon(true);
//        tac.setDaemon(true);
        tic.start();
        tac.start();
    }
}
