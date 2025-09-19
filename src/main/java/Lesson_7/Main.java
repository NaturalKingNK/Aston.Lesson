package Lesson_7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+7-999-111-22-33");
        phoneBook.add("Петров", "+7-999-222-33-44");
        phoneBook.add("Сидоров", "+7-999-333-44-55");
        phoneBook.add("Иванов", "+7-999-444-55-66"); // Второй номер для Иванова
        phoneBook.add("Петров", "+7-999-555-66-77"); // Второй номер для Петрова
        phoneBook.add("Кузнецов", "+7-999-666-77-88");

        phoneBook.printAll();

        searchAndPrint(phoneBook, "Иванов");
        searchAndPrint(phoneBook, "Петров");
        searchAndPrint(phoneBook, "Сидоров");
        searchAndPrint(phoneBook, "Кузнецов");
        searchAndPrint(phoneBook, "Несуществующий"); // Несуществующая фамилия

        phoneBook.add("Смирнов", "+7-999-777-88-99");
        phoneBook.add("Иванов", "+7-999-888-99-00"); // Третий номер для Иванова

        System.out.println("=== ПОСЛЕ ДОБАВЛЕНИЯ НОВЫХ ЗАПИСЕЙ ===");
        phoneBook.printAll();

        searchAndPrint(phoneBook, "Иванов");
    }

    private static void searchAndPrint(PhoneBook phoneBook, String lastName) {
        List<String> phones = phoneBook.get(lastName);
        if (phones.isEmpty()) {
            System.out.println("Фамилия '" + lastName + "' не найдена в справочнике.");
        } else {
            System.out.println("Номера телефонов для '" + lastName + "': " + phones);
        }
    }
}