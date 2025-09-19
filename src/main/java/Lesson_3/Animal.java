package Lesson_3;

class Animal {
    private String name;
    private static int totalAnimals = 0;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {}

    public void swim(int distance) {}

    public String getName() {
        return name;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    protected void finalize() {
        totalAnimals--;
    }
}