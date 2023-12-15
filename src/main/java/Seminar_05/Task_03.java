package Seminar_05;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * ● 3 бегуна должны прийти к старту гонки
 * ● Программа должна гарантировать, что гонка начнется только когда все три
 * участника будут на старте
 * ● Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * ● Программа должна завершиться когда все участники закончат гонку.
 * ● Подумайте об использовании примитива синхронизации
 */
public class Task_03 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch allStart = new CountDownLatch(3);
        CountDownLatch startRace = new CountDownLatch(1);

        try {
            Thread runnerThread1 = new Thread(new Runner(allStart, startRace));
            Thread runnerThread2 = new Thread(new Runner(allStart, startRace));
            Thread runnerThread3 = new Thread(new Runner(allStart, startRace));
            runnerThread3.start();
            runnerThread2.start();
            runnerThread1.start();
            allStart.await();
            System.out.println("На старт");
            Thread.sleep(500);
            System.out.println("Внимание");
            Thread.sleep(500);
            System.out.println("Марш");
            Thread.sleep(500);
            startRace.countDown();
            runnerThread1.join();
            runnerThread2.join();
            runnerThread3.join();
            System.out.println("Гонка завершена!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Runner implements Runnable {
        CountDownLatch readyToStart;
        CountDownLatch raceToStart;
        int sleepTime;
        public static Random rnd = new Random();

        public Runner(CountDownLatch readyToStart, CountDownLatch raceToStart) {
            this.readyToStart = readyToStart;
            this.raceToStart = raceToStart;
            sleepTime = rnd.nextInt(500, 2000);
        }

        @Override
        public void run() {
            try {
                System.out.println("Иду на старт " + Thread.currentThread().getName());
                Thread.sleep(sleepTime);
                readyToStart.countDown();
                raceToStart.await();
                System.out.println("Бегу " + Thread.currentThread().getName());
                Thread.sleep(rnd.nextInt(3000, 5000));
                System.out.println("Прибежал! " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
