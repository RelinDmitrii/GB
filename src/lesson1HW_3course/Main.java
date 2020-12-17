package lesson1HW_3course;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"Sun", "Beach", "Sea", "11555"};
        System.out.println("Вывести изначальный массив: "+ Arrays.toString(arr));
        swapElementsInArray(arr, 2, 3);
        System.out.println("Вывести массив с заменой элементов: "+ Arrays.toString(arr));

        List<String> list = convertToArrayList(arr);
        System.out.println("Вывести приобразованные массив" + list.getClass() + " : " + list);


        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3);
        Box<Orange> box2 = new Box<Orange>(orange1, orange2);

        System.out.println(box1.compare(box2));

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());

//        Box<Orange> box3 = new Box<Orange>();
//        box2.transfer(box3);



    }




    private static <T> void swapElementsInArray(T[] array, int index1, int index2) {
        T temporary = array[index1];
        array[index1] = array[index2];
        array[index2] = temporary;
    }

    private static <T> List<T> convertToArrayList(T[] array) {
        return Arrays.asList(array);
    }
}
