package lesson7HW;

import java.sql.SQLOutput;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int hungry, Cat cat){    //метод уменьшения еды в тарелке
        if(hungry<0){
            return;
        } else if (hungry>food){
            return;
        }
        food-=hungry;
        System.out.println(cat.getHunger());
    }

    public void addEatToPlate(int Eat){
        food+=Eat;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
