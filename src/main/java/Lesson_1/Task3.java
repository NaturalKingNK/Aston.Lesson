package Lesson_1;

public class Task3 {
    public static void main(String[] args) {
        printColor();
    }
        public static void printColor () {
            int value = 101;
            if (value <= 0) {
                System.out.println("Красный");
            } else if (value <= 100) {
                System.out.println("Желтый");
            } else if (value > 100) {
                System.out.println("Зеленый");
            }
        }
    }

