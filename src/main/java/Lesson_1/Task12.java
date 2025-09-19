package Lesson_1;

public class Task12 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 2, 10, 4, 7};

        System.out.println("Исходный массив:");
        printArray(array);

        multiplyLessThanSix(array);

        System.out.println("После умножения:");
        printArray(array);
    }

    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

