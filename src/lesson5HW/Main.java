package lesson5HW;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeList = new Employee[5];
        employeeList[0] = new Employee("Ivan Petrov", "manager", "petrov@mail.ru", 890666487, 65000, 34);
        employeeList[1] = new Employee("Sergey Ivanov", "engineer", "ivanov@mail.ru", 891745688, 35000, 18);
        employeeList[2] = new Employee("Nikolay Cidorov", "accountant", "cidorov@mail.ru", 890646487, 45000, 56);
        employeeList[3] = new Employee("Petr Gregoriev", "driver", "gregoriev@mail.ru", 891522227, 16000, 44);
        employeeList[4] = new Employee("Ignat Julebin", "director", "julebin@mail.ru", 890637498, 130000, 74);

        for (Employee p : employeeList) {
            if (p.getAge() > 40) {
                p.printInfo();
            }

        }
    }
}
