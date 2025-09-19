package Lesson_3;

class Dog extends Animal {
    private static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int distance) {
        int maxRun = 500;
        if (distance <= maxRun) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м. Максимум: " + maxRun + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        int maxSwim = 10;
        if (distance <= maxSwim) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(getName() + " не может проплыть " + distance + " м. Максимум: " + maxSwim + " м.");
        }
    }

    public static int getCount() {
        return count;
    }

    @Override
    protected void finalize() {
        count--;
    }
}