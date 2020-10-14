package lesson6HW.Animals;

public class Dog extends Animal{

    static final int MAX_RUN = 500;
    static final int MAX_SWIM = 10;
    static int counterForDog = 0;

    public static int getCounterForDog() {
        System.out.println("Было созданое объектов класса Dog: "+counterForDog);
        return counterForDog;
    }



    public Dog(String name, String color, int age) {
        super(name, color, age);
        counterForDog++;
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
            System.out.println(name+ " не сможет проплыть такую длину");
        } else System.out.println(name+ " проплыл: "+length+"м.");
    }

    @Override
    public void printCounter() {
        System.out.println(counterForDog);
    }
}
