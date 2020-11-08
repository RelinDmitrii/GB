package lesson1HW_2course;

public class Human implements Runnable,Jumpable {
    private String name;
    private int MAX_LENGTH;
    private int MAX_HEIGHT;

    public int getMAX_LENGTH() {
        return MAX_LENGTH;
    }

    public int getMAX_HEIGHT() {
        return MAX_HEIGHT;
    }

    public Human(String name, int MAX_LENGTH, int MAX_HEIGHT) {
        this.name = name;
        this.MAX_LENGTH = MAX_LENGTH;
        this.MAX_HEIGHT = MAX_HEIGHT;
    }

    @Override
    public boolean jump(int maxvalue) {
        System.out.println(name+" начал прыгать");
        if(maxvalue<=MAX_HEIGHT){
            System.out.println(name +" смог преодолеть препятсвие!!!");
            return true;
        } else {
            System.out.println(name+" слишком слаб для таких дисциплин!!!");
            return false;
        }
    }

    @Override
    public boolean run(int maxvalue) {
        System.out.println(name + " начал бежать");
        if (maxvalue <= MAX_LENGTH) {
            System.out.println(name + " смог преодолеть препятсвие!!!");
            return true;
        } else {
            System.out.println(name + " слишком слаб для таких дисциплин!!!");
            return false;
        }
    }
}
