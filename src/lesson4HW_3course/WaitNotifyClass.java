package lesson4HW_3course;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile String counter = "A";

    public static void main(String[] args) {
        WaitNotifyClass w = new WaitNotifyClass();
        new Thread(w::printA).start();
        new Thread(w::printB).start();
        new Thread(w::printC).start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (!counter.equals("A"))
                        mon.wait();
                    System.out.print("A");
                    counter = "B";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (!counter.equals("B"))
                        mon.wait();
                    System.out.print("B");
                    counter = "C";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (!counter.equals("C"))
                        mon.wait();
                    System.out.print("C");
                    counter = "A";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
