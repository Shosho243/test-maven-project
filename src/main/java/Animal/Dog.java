package Animal;

public class Dog extends Animal {
    public static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака " + getName() + " прибежал " + distance + "м");
        } else {
            System.out.println("Собака " + getName() + " не может пробежать такое расстояние ");
        }
    }

    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака " + getName() + " проплыла " + distance + "м");
        } else {
            System.out.println("Собака " + getName() + " не может проплыть такое расстояние");
        }
    }
}



