package Seminar_02.project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fullstacker fullstacker1 = new Fullstacker();
//        fullstacker1.back();
//        fullstacker1.front();
        Developer fullstacker2 = new Fullstacker();
        List<Developer> list = new ArrayList<>();
        list.add(fullstacker1);
        list.add(fullstacker2);
        list.add(new Backender());
        list.add(new Frontender());
        for (Developer dev : list) {
            requestMethod(dev);
        }

    }
    public static void requestMethod(Developer developer){
        if (developer instanceof Fullstacker) {
            ((Fullstacker) developer).back();
            ((Fullstacker) developer).front();
        } else if (developer instanceof Frontender) {
            ((Frontender) developer).front();
        } else if (developer instanceof Backender) {
            ((Backender) developer).back();
        }
    }
}
