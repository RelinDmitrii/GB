package lesson2HW_2course;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2"}, {"2", "2", "2", "2"}, {"2", "2", "2", "2"}};

            try {
                int resultSumma = arraySumma(arr);
                System.out.println(resultSumma);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            } catch (MyArrayDataException e) {
                System.out.println("Ошибка в ячейке массива: " + e.i + "x" + e.j);
            }


        }


    private static int arraySumma(String list[][]) throws MyArraySizeException, MyArrayDataException{
        int summaCounter = 0;
        if(list.length!=4){ // внешний массив
            throw new MyArraySizeException("Масиив может быть только размером 4x4");
        }
        for (int i = 0; i < list.length; i++) {
            if(list[i].length!= 4) {
                throw new MyArraySizeException("Масиив может быть только размером 4x4");
            }
            for (int j = 0; j < list[i].length; j++) {
                try {
                summaCounter = summaCounter + Integer.parseInt(list[i][j]); }

                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return summaCounter;




    }
}
