package com.aston;

import com.aston.MyArraySizeException;
import com.aston.MyArrayDataException;

public class Main {

    // Метод для обработки массива
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Неверное количество строк. Ожидается: 4, получено: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в строке " + i +
                        ". Ожидается: 4, получено: " + array[i].length);
            }
        }

        int sum = 0;

        // Проход по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, бросаем наше исключение
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" +
                            array[i][j] + "'");
                }
            }
        }

        return sum;
    }

    // Метод для генерации ArrayIndexOutOfBoundsException
    public static void generateArrayIndexOutOfBounds() {
        int[] array = {1, 2, 3};
        try {
            // Попытка доступа к несуществующему элементу
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Пример 1: Корректный массив
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример 2: Массив с ошибкой в данных
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"}, // Ошибка здесь
                {"13", "14", "15", "16"}
        };

        // Пример 3: Массив неверного размера
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // Обработка корректного массива
        try {
            System.out.println("Сумма корректного массива: " + processArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Обработка массива с ошибкой в данных
        try {
            System.out.println("Сумма массива с ошибкой: " + processArray(invalidDataArray));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        // Обработка массива неверного размера
        try {
            System.out.println("Сумма массива неверного размера: " + processArray(wrongSizeArray));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        // Генерация и поимка ArrayIndexOutOfBoundsException
        System.out.println("\nГенерация ArrayIndexOutOfBoundsException:");
        generateArrayIndexOutOfBounds();
    }
}