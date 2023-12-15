package Lecture_05;

import java.lang.reflect.Executable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Queue<Task> queue = new ArrayDeque<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread taskService = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    executor.submit(() -> {
                        Task task = queue.poll();
                        if (task != null) {
                            System.out.println("Task" + task + " started");
                            task.run();
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        taskService.start();
        while (scn.hasNextLine()) {
            //1+2
            try {
                String[] tokens = scn.nextLine().split("\\+");
                int leftToken = Integer.parseInt(tokens[0]);
                int rightToken = Integer.parseInt(tokens[1]);
                Task task = new Task(leftToken, rightToken);
                queue.add(task);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
}
