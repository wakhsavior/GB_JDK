package Lecture_05;

import java.util.Scanner;

public class ConsoleStatsHelper {
    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(()->{
            Scanner scn= new Scanner(System.in);
            while (scn.hasNext() && !Thread.interrupted()){
                String line = scn.nextLine();
                cnt++;
            }
        });
        readThread.setDaemon(true);
        readThread.start();
        readThread.interrupt();
        while (true) {
            System.out.println(cnt + " messages inputted.");
            Thread.sleep(1000);
        }
    }
}
