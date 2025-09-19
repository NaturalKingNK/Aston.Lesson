package Lesson_6;

import java.util.*;

public class UniversityManager {

    public static void removeFailingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() +
                        " (Группа: " + student.getGroup() +
                        ", Средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("На " + course + " курсе студентов не найдено.");
        }
        System.out.println();
    }

    public static void printAllStudents(Set<Student> students) {
        System.out.println("Все студенты:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван Иванов", "ГР-101", 1,
                Map.of("Математика", 5, "Физика", 4, "Информатика", 5)));

        students.add(new Student("Петр Петров", "ГР-102", 1,
                Map.of("Математика", 3, "Физика", 3, "Информатика", 2)));

        students.add(new Student("Мария Сидорова", "ГР-103", 2,
                Map.of("Математика", 4, "Физика", 5, "Информатика", 4)));

        students.add(new Student("Анна Козлова", "ГР-104", 2,
                Map.of("Математика", 2, "Физика", 2, "Информатика", 3)));

        students.add(new Student("Алексей Смирнов", "ГР-105", 3,
                Map.of("Математика", 5, "Физика", 5, "Информатика", 5)));

        System.out.println("=== НАЧАЛЬНОЕ СОСТОЯНИЕ ===");
        printAllStudents(students);

        printStudents(students, 1);

        removeFailingStudents(students);
        System.out.println("=== ПОСЛЕ УДАЛЕНИЯ НЕУСПЕВАЮЩИХ ===");
        printAllStudents(students);

        promoteStudents(students);
        System.out.println("=== ПОСЛЕ ПЕРЕВОДА НА СЛЕДУЮЩИЙ КУРС ===");
        printAllStudents(students);

        printStudents(students, 2);
    }
}