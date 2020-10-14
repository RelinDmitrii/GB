package lesson6HW.Animals;

public class Animal {

     String name;
     String color;
     int age;
     static int counterForAnimals = 0;

    public static int getCounterForAnimals() {
        System.out.println("Было созданое объектов класса Animals: "+counterForAnimals);
        return counterForAnimals;
    }



    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        counterForAnimals++;
    }

    public void animalRun (int length) {
        System.out.println(name + " пробежал: "+length+"м.");
    }

    public void animalSwim (int length) {
        System.out.println(name + " проплыл: "+length+"м.");
    }

    public void printCounter(){
        System.out.println(counterForAnimals);
    }

}
