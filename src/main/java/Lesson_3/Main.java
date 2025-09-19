package Lesson_3;

public class Main {

     private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String line = repeatChar('=', 50);
        String dash = repeatChar('-', 30);
        String dash40 = repeatChar('-', 40);
        String dash20 = repeatChar('-', 20);

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        System.out.println("\nВсего животных: " + Animal.getTotalAnimals());
        System.out.println("Собак: " + Dog.getCount());
        System.out.println("Котов: " + Cat.getCount());

        System.out.println("\n\n2. БЕГ И ПЛАВАНИЕ");
        System.out.println(dash40);

        dog1.run(300);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        System.out.println();
        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);

        System.out.println("\n\n3. МИСКА И ЕДА");
        System.out.println(dash40);

        FoodBowl bowl = new FoodBowl(50);
        System.out.println(bowl);

        bowl.addFood(30);
        System.out.println(bowl);

        Cat[] catsArray = {cat1, cat2, cat3};

        System.out.println("\nКормим котов:");
        System.out.println(dash20);

        for (int i = 0; i < catsArray.length; i++) {
            Cat cat = catsArray[i];
            System.out.println("\nКот " + (i + 1) + ": " + cat.getName());
            boolean success = cat.eat(bowl, 25);
            if (success) {
                System.out.println("✅ " + cat.getName() + " успешно поел!");
            } else {
                System.out.println("❌ " + cat.getName() + " остался голодным!");
            }
        }

        System.out.println("\nОсталось еды в миске: " + bowl.getFoodAmount());

        System.out.println("\n4. ПЫТАЕМСЯ ПОКОРМИТЬ СНОВА");
        System.out.println(dash40);

        cat1.eat(bowl, 10);

        System.out.println("\n5. ДОБАВЛЯЕМ ЕДУ И КОРМИМ");
        System.out.println(dash40);

        bowl.addFood(40);
        boolean feedSuccess = cat1.eat(bowl, 15);
        System.out.println("Результат кормления: " + (feedSuccess ? "успешно" : "не удалось"));
        System.out.println("Сытость " + cat1.getName() + ": " + (cat1.isHungry() ? "❌ Голоден" : "✅ Сыт"));

        System.out.println("\n6. СОСТОЯНИЕ ВСЕХ КОТОВ:");
        System.out.println(dash);
        for (Cat cat : catsArray) {
            System.out.println(cat);
        }

        System.out.println("\n\n7. СТАТИСТИКА");
        System.out.println(dash20);
        System.out.println("Всего животных: " + Animal.getTotalAnimals());
        System.out.println("Собак: " + Dog.getCount());
        System.out.println("Котов: " + Cat.getCount());

        System.out.println("\n\n8. ТЕСТИРУЕМ ГРАНИЧНЫЕ СЛУЧАИ");
        System.out.println(dash40);

        bowl.addFood(-10);

        bowl.takeFood(-5);

        bowl.takeFood(0);

        FoodBowl emptyBowl = new FoodBowl();
        System.out.println("\nПустая миска: " + emptyBowl);

        cat2.eat(emptyBowl, 10);

    }
}