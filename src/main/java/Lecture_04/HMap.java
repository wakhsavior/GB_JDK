package Lecture_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Integer, Integer
public class HMap {
    private int capacity;
private ArrayList<LinkedList<Integer>> map;

    public HMap() {
        capacity = 100;
        this.map = new ArrayList<>();
        for (int i=0; i<capacity;i++){
            map.add(new LinkedList<>());
        }
    }
    public void put(Integer key, Integer value){
        int code = key.hashCode() % capacity;
        LinkedList<Integer> list =  map.get(code);
        if (!list.contains(value)){
            list.add(value);
        }
    }

    public static void main(String[] args) {
        Map<String,Integer> map = Map.of("Hello",1, "World",2);
        for (var entry: map.entrySet()
             ) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        for (String s: map.keySet()
        ) {
            System.out.println(s + " : " + map.get(s));
        }
        map.forEach((k,v)-> System.out.println(k+ " : " + v));
    }
}
