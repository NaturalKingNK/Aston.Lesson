package Lesson_4;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== КАЛЬКУЛЯТОР ГЕОМЕТРИЧЕСКИХ ФИГУР ===\n");

        GeometricShape circle = new Circle(5.0, "Красный", "Черный");
        GeometricShape rectangle = new Rectangle(4.0, 6.0, "Синий", "Белый");
        GeometricShape triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый");

        System.out.println("КРУГ:");
        circle.displayInfo();

        System.out.println("ПРЯМОУГОЛЬНИК:");
        rectangle.displayInfo();

        System.out.println("ТРЕУГОЛЬНИК:");
        triangle.displayInfo();

        System.out.println("ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ:");

        GeometricShape smallCircle = new Circle(2.5, "Розовый", "Серый");
        System.out.println("МАЛЕНЬКИЙ КРУГ:");
        smallCircle.displayInfo();

        GeometricShape square = new Rectangle(5.0, 5.0, "Оранжевый", "Коричневый");
        System.out.println("КВАДРАТ:");
        square.displayInfo();
    }
}