package lesson4HW;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 5; // Размер поля
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while(true) {
            humanTurn();
            printMap();
            if(checkWin(DOT_X)){
                System.out.println("Вы победель!");
                break;
            }
            if(isFull()){
                System.out.println("НИЧЬЯ!");
                break;
            }

            aiTurn();
            printMap();
            if(checkWin(DOT_O)){
                System.out.println("Компьютер победил!");
                break;
            }
            if(isFull()){
                System.out.println("НИЧЬЯ!");
                break;
            }
        }
    }

    /**
     * Метод, который заполняет все поле пустыми значками.
     */
    static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод, который распечатывает карты
     */
    static void printMap(){
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Метод, который вывзывает ход человека, при помощи ввода с клавиатуры координат XY.
     */
    static void humanTurn(){
         int x;
         int y;
    do{
        System.out.println("Введите координаты X Y");
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
      } while (!isCellValid(y,x));

        map[y][x] = DOT_X;
    }

    /**
     * Метод, который вывзывает ход компьютера, заполняется рандомное число с координатами XY.
     */
    static void aiTurn(){
        int x;
        int y;
        boolean found = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY){
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)){
                        found = true;
                        map[i][j] = DOT_O;
                        break;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
            if (found) break;
        }

        if (!found) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;
        }
    }



    /**
     * Метод, который проверяте волидность строки, на заполнение.
     */
    static boolean isCellValid(int y, int x){
        if(x<0 || y<0 || x>=SIZE || y >= SIZE){
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    /**
     * Метод, который проверяет поле на пустые ячейки (НИЧЬЯ)
     */
    static boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Метод проверяющий победу.
     */
    static boolean checkWin(char c){
        int counter = 0;
        for (int i = 0; i  < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == c){
                    counter++;
                }
                if(counter==DOTS_TO_WIN){
                    return true;
                }
            }
            counter = 0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == c) {
                    counter++;
                }
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            }
            counter = 0;
        }

        for (int i = 0; i < SIZE; i++) {
            if(map[i][i] == c){
                counter ++;
            } else counter = 0;
            if (counter == DOTS_TO_WIN){
                return true;
            }
        }
        counter =0;

        for (int i = 0; i < SIZE; i++) {
            if(map[4 - i][i] == c){
                counter ++;
            } else counter = 0;
            if (counter == DOTS_TO_WIN){
                return true;
            }
        }
        counter =0;

        // Проверка побочных диагоналей
        int counter2 = 0;
        for (int i = 0; i < SIZE-1; i++) {
            if(map[i+1][i] == c){
                counter ++;
            }
            if(map[i][i+1] == c){
                counter2 ++;
            }
            if (counter == DOTS_TO_WIN || counter2 == DOTS_TO_WIN){
                return true;
            }
        }
        counter =0;
        counter2 =0;

        // Проверка обратных диагоналей
        for (int i = 0; i < SIZE-1; i++) {
            if(map[3-i][i] == c){
                counter ++;
            }
            if(map[4-i][i+1] == c){
                counter2 ++;
            }

            if (counter == DOTS_TO_WIN || counter2 == DOTS_TO_WIN){
                return true;
            }
        }

        return false;




//        if (map[0][0] == c && map[0][1] == c && map[0][2] == c){ return true;}
//        if (map[1][0] == c && map[1][1] == c && map[1][2] == c){ return true;}
//        if (map[2][0] == c && map[2][1] == c && map[2][2] == c){ return true;}
//
//        if (map[0][0] == c && map[1][0] == c && map[2][0] == c){ return true;}
//        if (map[0][1] == c && map[1][1] == c && map[2][1] == c){ return true;}
//        if (map[0][2] == c && map[1][2] == c && map[2][2] == c){ return true;}
//
//        if (map[0][0] == c && map[1][1] == c && map[2][2] == c){ return true;}
//        if (map[0][2] == c && map[1][1] == c && map[2][0] == c){ return true;}

//        return false;
    }
}
