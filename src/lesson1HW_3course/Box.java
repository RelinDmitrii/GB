package lesson1HW_3course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public Box(T... obj) {
        list = Arrays.asList(obj);
    }

    public Box() {
        list = new ArrayList<T>();
    }

    void add(T obj) {
        list.add(obj);
    }

    public float getWeight() {
        if (list.size() == 0) return 0;
        float weight = 0;
        for (T element: list) weight += element.getWeight();
        return weight;
    }

    boolean compare(Box<? extends Fruit> box) {
        //return this.getWeight() == box.getWeight();
        return Math.abs(this.getWeight() - box.getWeight()) < 0.000001;
    }

    public void swap(Box<? super T> box) {
        box.list.addAll(this.list);
        list.clear();

    }



}
