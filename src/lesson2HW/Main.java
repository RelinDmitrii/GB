package lesson2HW;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {

        //Задача №1
        int[] arr = {1,1,1,1,1,0,0,0,0,1};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                arr[i]=0;
            } else {
                arr[i]=1;
            }
            System.out.println(arr[i]);
        }

        // Задача №2.
        int[] arr2 = new int[8];
        int b = 0;
        for (int i = 0; i <arr2.length ; i++) {
            arr2[i] = b;
            System.out.println(arr2[i]);
            b+=3;
        }

        // Задача №3
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i]<6){
                arr3[i]=arr3[i]*2;
            }
            System.out.println(arr3[i]);

        }

        // Задача №4
        int[][] cross = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int g = 0; g < 5; g++) {
                if(i==g || i+g==cross.length-1){
                    cross[i][g] = 1;
                }
                System.out.print(cross[i][g]);
            }
            System.out.println();
        }

    }

    /**
     * Этот метод сортирует массив по возростанию и возвращает минимальный элемент
     * @param arr4 Переданный массив.
     * */
    public static int arrMin(int[] arr4) {
        Arrays.sort(arr4);
        return arr4[0];
    }

    /**
     * Этот метод сортирует массив по убыванию и возвращает максимальный элемент (Примитивный вариант).
     * @param arr6 Переданный массив.
     * */
    public static int arrMax(int[] arr6) {
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = arr6[i] * -1;
        }
        Arrays.sort(arr6);
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = arr6[i] * -1;
        }
        return arr6[0];
    }

    /**
     * Этот метод сортирует массив по убыванию и возвращает максимальный элемент (Классический вариант).
     * @param arr7 Переданный массив.
     * */
    public static int arrMax2(int[] arr7) {
        int max = 0;
        for (int i = 0; i < arr7.length; i++) {
            if (arr7[i] > max) {
                max = arr7[i];
            }
        }
        return max;
    }

    /**
     * Этот метод, возвращает true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * @param arr8 Переданный массив.
     * */
    public static boolean leftAndRightSide(int[] arr8) {
        int summa = 0;
        int[] arrayCopy = new int[arr8.length];
        for (int i = 1; i < arr8.length; i++) {
            arrayCopy=Arrays.copyOfRange(arr8,i,arr8.length);
            summa = summa + arr8[i-1];
            if(summa == Arrays.stream(arrayCopy).sum()){
                return true;
            }
        }
        return false;
    }
    /**
     * Этот метод сдвигает элементы массива (вправо/влево) на конкретное число элементов в зависимости от входных данных
     * @param arr Переданный массив
     * @param a Параметр сдвига(влево/вправо)
     * */
    public static void leftRight(int[] arr, int a){
        //left
        if(a<0) {
            for (int i = 0; i < (a * -1); i++) {
                int b = arr[0];
                for (int j = 1; j <= arr.length - 1; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 1] = b;
            }
        }
        // right
        else {
            for (int i = 0; i < a; i++) {
                int b = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = b;
            }
        }
        for(int c: arr) System.out.print(c);
    }
}
