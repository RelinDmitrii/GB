package lesson1HW;

public class Main {
    public static void main(String[] args) {
        // Примитивные
        byte a = 6;
        short b = 16;
        int g = 547;
        long c = 1571289571;
        float d = 5.156535F;
        double k = 5.124124125353;
        char p = 68;
        boolean t = true;
        // Ссылочные
        String u = "Hello";

        System.out.println(computation(5,6,9,4));
        System.out.println(sum(10,11));
        printPlusMinus(-6);
        System.out.println(plusMinus(-6));
        printName("Bob");
        leapYear(1800);
    }
    static float computation(float a, float b, float c, float d){

        return a * (b + (c / d));
    }

    static boolean sum(double f, double g){
        if ((f+g)>9 && (f+g)<21){
            return true;
        }
        else {
            return false;
        }
    }

    static void printPlusMinus(int t){
        if (t>=0){
            System.out.println("Положительное");
        }
        else {
            System.out.println("Отрицательное");
        }
    }

    static boolean plusMinus(int k){
        return k < 0; // упращенная версия можно расписать полностью так же как в методе SUM
        }


    static void printName(String p){

        System.out.println("Привет, "+p+"!");
    }

    static void leapYear(int y){
        if(y%400==0){
            System.out.println("високосный");
        } else if (y%100==0){
            System.out.println("не високосный");
        } else if (y%4==0){
            System.out.println("високосный");
        } else {
            System.out.println("не високосный");
        }
    }

}
