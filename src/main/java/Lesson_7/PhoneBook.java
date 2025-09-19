package Lesson_7;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        // Если фамилия уже есть в справочнике, добавляем номер к существующему списку
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        // Возвращаем список номеров или пустой список, если фамилии нет
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public Map<String, List<String>> getAllEntries() {
        return new HashMap<>(phoneBook);
    }

    public void printAll() {
        System.out.println("=== ТЕЛЕФОННЫЙ СПРАВОЧНИК ===");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}