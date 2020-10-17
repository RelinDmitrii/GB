package lesson7HW;

public class Cat {
    private String name;
    private int hunger;
    private boolean satiety = false;


    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHunger() {
        return hunger;
    }


    public Cat(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate){
        System.out.println("Cat "+name+" eat");
        if(hunger>plate.getFood()){
            System.out.println("В тарелке слишком мало еды");
        } else {
            satiety = true;
            System.out.println("Кот "+name+" "+ satiety);
        }


    }


}
