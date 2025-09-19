package Lesson_1;

public class Task13 {
    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];

        System.out.println("Исходная матрица (все нули):");
        printMatrix(matrix);

        fillDiagonals(matrix);

        System.out.println("Матрица после заполнения диагоналей:");
        printMatrix(matrix);
    }

    public static void fillDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
