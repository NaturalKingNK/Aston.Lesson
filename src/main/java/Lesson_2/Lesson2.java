package Lesson_2;

public class Lesson2 {

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product(1L, "Suzuki GSX-R", "03.05.1984", "Suzuki", "Japan", 599999,
                4, false);
        productsArray[1] = new Product(2L, "Honda CBR 919RR Fireblade", "04.06.1996", "Honda", "Japan", 35678.14,
                7, false);
        productsArray[2] = new Product(3L, "Yamaha YZF-R6", "11.03.1999", "Yamaha", "Japan", 4351131.14,
                2, false);
        productsArray[3] = new Product(4L, "VOGE AC 525 X", "09.03.2024", "VOGE", "China", 444194.11, 5,
                false);
        productsArray[4] = new Product(5L, "Ducati Diavel", "14.08.2011", "Avtovaz", "Italy", 7894123.93,
                1, true);

        System.out.println("Информация о товаре");
        for (Product product : productsArray) {
            product.info();
            System.out.println("------------------------------------------");
        }

        Park.Attraction[] attractionsArray = new Park.Attraction[5];
        attractionsArray[0] = new Park.Attraction(1L, "Емеля",
                "09.00 - 20.00",
                249.0);

        attractionsArray[1] = new Park.Attraction(2L, "Машинки",
                "09.00 - 20.00",
                800.0);

        attractionsArray[2] = new Park.Attraction(3L, "Колесо обозрения",
                "09.00 - 20.00",
                150.0);

        attractionsArray[3] = new Park.Attraction(2L, "Американские горки",
                "09.00 - 20.00",
                300.0);

        attractionsArray[4] = new Park.Attraction(2L, "Лошадки",
                "09.00 - 20.00",
                199.0);

        System.out.println("Аттракционы в парке");
        for (Park.Attraction attraction : attractionsArray) {
            attraction.info();


        }
    }
}
