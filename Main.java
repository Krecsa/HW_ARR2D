import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static int[][] colors = new int[SIZE][SIZE];
    public static int[][] rotatedColors = new int[SIZE][SIZE];
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotate90() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[i][j] = colors[SIZE - 1 - j][i];
            }
        }
    }

    public static void rotate180() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
            }
        }
    }

    public static void rotate270() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[i][j] = colors[j][SIZE - 1 - i];
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        System.out.println("Дана следующая матрица:");
        printMatrix(colors);

        while (true) {
            System.out.println("Выберите желаемое действие с матрицей");
            System.out.println("1. Повернуть матрицу на 90 градусов");
            System.out.println("2. Повернуть матрицу на 180 градусов");
            System.out.println("3. Повернуть матрицу на 270 градусов");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    rotate90();
                    System.out.println("Матрица после поворота на 90 градусов:");
                    printMatrix(rotatedColors);
                    break;

                case 2:
                    rotate180();
                    System.out.println("Матрица после поворота на 180 градусов:");
                    printMatrix(rotatedColors);
                    break;

                case 3:
                    rotate270();
                    System.out.println("Матрица после поворота на 270 градусов:");
                    printMatrix(rotatedColors);
                    break;

                default:
                    System.out.println("Нет такого действия");
                    break;
            }
        }
    }
}