package Lesson_2;

public class Park {

    public static class Attraction {
        private  Long id;
        private  String name;
        private  String workingHours;
        private  double price;

        public Attraction(Long id, String name, String workingHours, double price) {
            this.id = id;
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void info() {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + id);
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
        }
    }
}
