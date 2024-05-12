package Animal;

public class Cat extends Animal {
    public static int catCount = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот " + getName() + " пробежал " + distance + "м");
        } else {
            System.out.println("Кот " + getName() + " не может пробежать такое расстояние ");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот " + getName() + " не умеет плавать");

    }

    public void eat(Bowl bowl, int amount) {
        if (amount <= 0) {
            System.out.println("Кот не может съесть отрицательное количество еды ");
            return;
        }
        if (amount <= bowl.getFoodAmount()) {
            System.out.println(getName() + " покушал " + amount + " кормы");
            bowl.decreaseFood(amount);
            isFull = true;
        } else {
            System.out.println("Недостаточно еды в миске для кота " + getName());
        }
    }


    public boolean isFull() {
        return isFull;
    }
}
