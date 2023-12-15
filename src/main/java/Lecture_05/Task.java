package Lecture_05;

public class Task implements Runnable{
    private final int left,right;
    Task(int left,int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("(%s+%s)",left,right);
    }

    @Override
    public void run() {
        System.out.println(left+right);
    }
}
