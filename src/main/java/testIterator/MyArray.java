package testIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MyArray implements Iterable {
    private final int DEFAULTARRAYLENGTH = 4;
    int[] array;
    int size;

    MyArray() {
        this.array = new int[DEFAULTARRAYLENGTH];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    void add(int elem) {
        if (array.length == size) {
            int[] tmpArray = new int[array.length * 2];
            System.arraycopy(array,0,tmpArray,0,array.length);
            tmpArray[size] = elem;
            array = tmpArray;
        } else {
            array[size] = elem;
        }
        size++;
    }
    int arrayLength(){
        return array.length;
    }

    @Override
    public Iterator iterator() {
        return new MyListIterator();
    }

    class MyListIterator implements Iterator {
        int curNumber = 0;

        @Override
        public boolean hasNext() {
            if(size == curNumber){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            return array[curNumber++];
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int num: array) {
            str = str + String.valueOf(num) + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        MyArray myArray = new MyArray();
        for (int i = 0; i<20;i++){
            myArray.add(rnd.nextInt(100));
            System.out.printf(myArray.toString()+ " Array Length: " + myArray.arrayLength());
            System.out.println();
        }
    }
}
