package lesson3HW_2course;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> duplicates = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Море", "Солнце", "Пляж", "Зонт", "Ракушка", "Солнце", "Природа", "Отпуск", "Пляж", "Сон"));


        for (int i = 0; i < list.size(); i++) {

        if(!duplicates.containsKey(list.get(i))){
           duplicates.put(list.get(i),1);
        } else{
            duplicates.put(list.get(i), duplicates.get(list.get(i))+1);
            }
        }
        Set <String> uniqueValues = new HashSet<>();
        uniqueValues.addAll(list);


        System.out.println(uniqueValues);
        System.out.println(duplicates);
        }
    }

