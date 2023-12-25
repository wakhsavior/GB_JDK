package Seminar_05_HW;

public class Philosopher implements Runnable {
    Thread philosopherThread;
    private static Object plate = new Object();
    private static final int MAXEATCOUNT = 3;

    int eatedcount;

    Philosopher(String name) {
        this.philosopherThread = new Thread(this, name);
        eatedcount = 0;
    }

    public static Philosopher createAndStart(String name) {
        Philosopher philosopher = new Philosopher(name);
        philosopher.philosopherThread.start();
        return philosopher;
    }

    @Override
    public void run() {
        System.out.println("Философ " + this.philosopherThread.getName() + " присоединился к обеду.");

        while (true) {
            synchronized (plate) {
                int eat = eatedcount+1;
                System.out.println("Философ " + this.philosopherThread.getName() + " кушает " + eat + "-й раз.");
                eatedcount++;
                try {
                    Thread.sleep(500);
                    if (eatedcount ==3){
                        plate.notifyAll();
                        break;
                    }
                    System.out.println("Философ " + this.philosopherThread.getName() + " размышляет.");
                    plate.notifyAll();
                    plate.wait();

                } catch (InterruptedException e) {
                    System.out.println("Философ " + this.philosopherThread.getName() + " неожиданно прервал трапезу.");
                }
            }
        }
        System.out.println("Философ "+ this.philosopherThread.getName() + " насылится.");
    }
}
class Meal{
    public static void main(String[] args) {
        Philosopher phil1 = Philosopher.createAndStart("Аристотель");
        Philosopher phil2 =Philosopher.createAndStart("Сократ");
        Philosopher phil3 =Philosopher.createAndStart("Платон");
        Philosopher phil4 =Philosopher.createAndStart("Гераклит");
        Philosopher phil5 =Philosopher.createAndStart("Конфуций");
        try {
            phil1.philosopherThread.join();
            phil2.philosopherThread.join();
            phil3.philosopherThread.join();
            phil4.philosopherThread.join();
            phil5.philosopherThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все философы поели, обед закончен.");

    }
}
