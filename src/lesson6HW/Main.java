package lesson6HW;

import lesson6HW.Animals.*;


public class Main {
    public static void main(String[] args) {

    Animal[] animals = {
            new Cat("Vasia", "red", 7),
            new Cat("Bublik", "orange", 4),

            new Dog("Bobik", "black", 10),
            new Dog("Weider", "white-black", 4),
            new Dog("Weider", "white-black", 4),
        };


        for (int i = 0; i < animals.length; i++) {
           animals[i].animalRun(150);
           animals[i].animalSwim(260);
        }


        Dog.getCounterForDog();
        Cat.getCounterForCat();
        Animal.getCounterForAnimals();

    }
}
