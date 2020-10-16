package lesson7HW;


public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(100);

        Cat[] cats = new Cat[]{
                new Cat("Barsik", 20),
                new Cat("foma", 40),
                new Cat("Garik", 50),
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.decreaseFood(cats[i].getHunger(),cats[i]);
        }

        System.out.println(plate);
        plate.addEatToPlate(100);
        System.out.println(plate);

    }
}
