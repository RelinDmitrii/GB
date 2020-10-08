package lesson5HW;

import sun.awt.windows.WPrinterJob;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }




    public Employee(String fullName, String position, String email, long phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.printf("Employee %s %s %s %d %d %d\n", fullName, position, email, phoneNumber, salary, age);
    }


}
