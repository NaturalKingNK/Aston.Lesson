package Lesson_1;

public class Task11 {
    public static void main(String[] args) {
            int[] resultArray = fillArray();

            System.out.println("Заполненный массив:");
            for (int i = 0; i < resultArray.length; i++) {
                System.out.print(resultArray[i] + " ");
                if ((i + 1) % 25 == 0) {
                    System.out.println();
                }
            }
        }

        public static int[] fillArray() {
            int[] array = new int[100];
            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }
            return array;
        }
    }