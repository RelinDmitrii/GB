package lesson6HW.Animals;

public class Cat extends Animal {

    static final int MAX_RUN = 200;
    static final int MAX_SWIM = 0;
    static int counterForCat = 0;


    public static int getCounterForCat() {
        System.out.println("Было созданое объектов класса Cat: "+counterForCat);
        return counterForCat;
    }




    public Cat(String name, String color, int age) {
        super(name, color, age);
        counterForCat++;
    }

    @Override
    public void animalRun(int length) {
        if(length>MAX_RUN || length<0){
            System.out.println(name+" не сможет пробежать такую длину");
        } else System.out.println(name+ " пробежал: "+length+"м.");
    }

    @Override
    public void animalSwim(int length) {
        if(length>MAX_SWIM || length<0){
            System.out.println("К сожалению коты не умеют плавать");
        } else System.out.println("К сожалению коты не умеют плавать");
    }

    @Override
    public void printCounter() {
        System.out.println(counterForCat);
    }
}
