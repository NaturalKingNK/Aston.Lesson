package Lesson_3;

import Lesson_3.FoodBowl;

class Cat extends Animal {
    private static int count = 0;
    private boolean hungry;

    public Cat(String name) {
        super(name);
        this.hungry = true;
        count++;
    }

    @Override
    public void run(int distance) {
        int maxRun = 200;
        if (distance <= maxRun) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м. Максимум: " + maxRun + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать!");
    }

    public boolean eat(FoodBowl bowl, int amount) {
        if (bowl.takeFood(amount)) {
            hungry = false;
            System.out.println(getName() + " поел " + amount + " еды и теперь сыт!");
            return true;
        } else {
            System.out.println(getName() + " не смог поесть. Не хватает еды в миске!");
            return false;
        }
    }

    public boolean isHungry() {
        return hungry;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Кот " + getName() + ", сытость: " + (hungry ? "голоден" : "сыт");
    }

    @Override
    protected void finalize() {
        count--;
    }
}