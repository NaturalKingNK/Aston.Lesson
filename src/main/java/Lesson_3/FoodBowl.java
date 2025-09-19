package Lesson_3;

class FoodBowl {
    private int food;

    public FoodBowl() {
        this(0);
    }

    public FoodBowl(int initialFood) {
        this.food = Math.max(0, initialFood);
    }

    public boolean addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске: " + food + " еды");
            return true;
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды!");
            return false;
        }
    }

    public boolean takeFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя взять отрицательное количество еды!");
            return false;
        }

        if (food >= amount) {
            food -= amount;
            return true;
        } else {
            System.out.println("Не хватает еды! В миске: " + food + ", требуется: " + amount);
            return false;
        }
    }

    public int getFoodAmount() {
        return food;
    }

    @Override
    public String toString() {
        return "Миска с едой: " + food + " единиц";
    }
}