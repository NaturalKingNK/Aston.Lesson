package Lesson_1;

public class Task10 {
    public static void main(String[] args) {
        int[] array = {1, 0, 1, 0, 1, 1, 0};

        System.out.println("Исходный массив:");
        printArray(array);

        invertArray(array);

        System.out.println("Инвертированный массив:");
        printArray(array);
    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }
     public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

