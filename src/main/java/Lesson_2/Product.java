package Lesson_2;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Product {
    private  Long id;
    private  String name;
    private  Date productionDate;
    private  String manufacturer;
    private  String countryOfOrigin;
    private  double price;
    private  Integer quantity;
    private  boolean isReserved;

    public Product(Long id, String name, String productionDateStr, String manufacturer,
                   String countryOfOrigin, double price, Integer quantity, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.quantity = quantity;
        this.isReserved = isReserved;

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            this.productionDate = format.parse(productionDateStr);
        } catch (Exception e) {
            this.productionDate = new Date();
        }
    }

    public void info() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String dateStr = format.format(productionDate);
        String reservedStatus = isReserved ? "Зарезервирован" : "Свободен";

        System.out.println("ID: " + id);
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + dateStr);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Количество: " + quantity);
        System.out.println("Статус бронирования: " + reservedStatus);
    }
}
