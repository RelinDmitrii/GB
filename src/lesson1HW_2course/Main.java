package lesson1HW_2course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Object[] objects = {
                new Treadmill(3),
                new Wall(6)
        };

        ArrayList<Object> users = new ArrayList (
                Arrays.asList(
                        new Cat("Weider",2,2),
                        new Robot("R2D2",1,7),
                        new Human("Bob",3,1)
                ));

        for (Object k: objects) {
            Iterator<Object> iter = users.iterator();

            while (iter.hasNext()) {
                Object l = iter.next();
                if(k instanceof Treadmill){
                    Runnable runnable = (Runnable) l;
                    if (!runnable.run(((Treadmill) k).getLENGTH())){
                        iter.remove();
                    }
                } else if (k instanceof Wall) {
                    Jumpable jumpable = (Jumpable) l;
                    if(!jumpable.jump(((Wall) k).getHEIGHT())){
                        iter.remove();
                    }
                }
            }

        }

    }


}
