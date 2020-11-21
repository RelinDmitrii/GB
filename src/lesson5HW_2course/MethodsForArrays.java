package lesson5HW_2course;

import java.util.concurrent.Callable;

public class MethodsForArrays {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    public static float[] arr = new float[SIZE];
    public static float[] arr1 = new float[HALF];
    public static float[] arr2 = new float[HALF];

    public float[] calculate (float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
    public void startOneThread(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Однопточный метод закончит свою работу через: " + (System.currentTimeMillis() - startTime));
    }

    public void startTwoThreads(){

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> {
            arr1 = calculate(arr1);});
        Thread thread2 = new Thread(() -> {
            arr2 = calculate(arr2);
           });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Метод с двумя потоками закончит свою работу через: " + (System.currentTimeMillis() - startTime));
    }
}
