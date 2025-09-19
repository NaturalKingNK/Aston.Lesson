package Lesson_1;

public class Task14 {
    public static void main(String[] args) {
            int[] array1 = createArray(5, 10);
            int[] array2 = createArray(8, -3);
            int[] array3 = createArray(3, 7);

            System.out.println("Массив 1 (длина 5, значение 10):");
            printArray(array1);

            System.out.println("Массив 2 (длина 8, значение -3):");
            printArray(array2);

            System.out.println("Массив 3 (длина 3, значение 7):");
            printArray(array3);
        }

        public static int[] createArray(int len, int initialValue) {
            int[] array = new int[len];
            for (int i = 0; i < len; i++) {
                array[i] = initialValue;
            }
            return array;
        }

        public static void printArray(int[] array) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

