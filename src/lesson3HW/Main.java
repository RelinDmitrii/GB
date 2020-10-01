package lesson3HW;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        // Задча №1
//        int randomNumber = random.nextInt(10) + 0;
//        int answer;
//        int answerContinue;
//        do {
//            for (int i = 3; i > 0; i--) {
//                System.out.println("Вам предстоит угадать число в диапазоне от 0 до 9, на это у Вас есть " + i + " попытки");
//                System.out.println("Введите число: ");
//                answer = scanner.nextInt();
//
//                if (answer == randomNumber) {
//                    System.out.println("Вы угадали");
//                    break;
//                } else if (answer < randomNumber) {
//                    System.out.println("Ваше число меньше загаданного\nУ Вас осталось попыток: " + (i - 1));
//                } else if (answer > randomNumber) {
//                    System.out.println("Ваше число больше загаданного\nУ Вас осталось попыток: " + (i - 1));
//                }
//                if (i - 1 == 0) {
//                    System.out.println("Вы проиграли");
//                }
//            }
//            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
//            answerContinue = scanner.nextInt();
//        }
//        while (answerContinue == 1);

//        // Задача №2 ----------------------------------
        String[] arrayWords = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = arrayWords[random.nextInt(arrayWords.length - 1)];
        String exit = "ВЫХОД";
        System.out.println(word);

        do {
            System.out.println("Я загадал слово и сейчас ты должен его угадать\nЕсли тебе надоест играть просто введи ВЫХОД");
            String answer = scanner.nextLine();
            if (answer.equals(word)) {
                System.out.println("Поздравляю ты победил");
                break;
            } else if (answer.equals(exit)) {
                break;
            }
            char[] arrayBreaker = answer.toCharArray();
            char[] arrayLattice = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
            int counter = 0;
            for (int i = 0; i < word.length(); i++) {
                if (i >= arrayBreaker.length) {
                    break;
                    }
                    if (word.charAt(i) == arrayBreaker[i]) {
                        arrayLattice[i] = arrayBreaker [i];

                    }
                }

            System.out.println(arrayLattice);
            }
         while (true);
    }
}
