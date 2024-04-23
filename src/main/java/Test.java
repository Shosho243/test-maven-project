import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(11,31);
        printColor();
        compareNumbers(5,8);
        boolean resultFive = checkSumInRange(6, 5);
        System.out.println("Задание 5 " + resultFive);
        checkNumber(67);
        boolean resultSeven = isNegative(-45);
        System.out.println("Задание 7 " + resultSeven);
        printStringMultipleTimes(3, "Hello");
        boolean resultNine = checkLeapYear(2024);
        System.out.println("Задание 9 " + resultNine);
        toggleArrayElements();
        fillArray();
        multiplySmallNumbersByTwoIfLessThanSix();
        fillDiagonalElementsWithOnes();
        createArray(5, 10);
    }

    static void printThreeWords() {
        System.out.println("Задание 1 " + "Orange, Banana, Apple");
    }

    static void checkSumSign(int a, int b) {
        if (a+b >= 0) {
            System.out.println("Задание 2 " + "Сумма положительная");
        } else {
            System.out.println("Задание 2 " + "Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 3;
        if (value < 0) {
            System.out.println("Задание 3 " + "Красный");
        } else if (value <= 100) {
            System.out.println("Задание 3 " + "Желтый");
        } else System.out.println("Задание 3 " + "Зеленый");
    }

    static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("Задание 4 " + "a>=b");
        } else {
            System.out.println("Задание 4 " + "a < b");
        }
    }

    public static boolean checkSumInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }


    static void checkNumber(int a) {
        if (a >= 0) {
            System.out.println("Задание 6 " + "положительное число ");
        } else System.out.println("Задание 6 " + "Отрицательное число ");
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    static void printStringMultipleTimes(int a, String str) {
        System.out.println("Задание 8 ");
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    public static boolean checkLeapYear(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    static void toggleArrayElements() {
        System.out.print("Задание 10 ");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else array[i] = 0;
        }
        System.out.print(Arrays.toString(array));

    }

    static void fillArray() {
        System.out.print("\nЗадание 11 ");
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.print(" " + Arrays.toString(array));

    }

    static void multiplySmallNumbersByTwoIfLessThanSix() {
        System.out.println("\nЗадание 12 ");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.print(" " + Arrays.toString(array));
    }

    static void fillDiagonalElementsWithOnes() {
        System.out.println("\nЗадание 13 ");
        int[][] table = new int[5][5];
        for (int i = 0; i < 5; i++) {
            table[i][i] = 1;
            table[i][5 - 1 - i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void createArray(int len, int initialValue) {
        System.out.println("\nЗадание 14 ");

        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        for (int o : array) {
            System.out.print(o + " ");
        }
    }
}


















