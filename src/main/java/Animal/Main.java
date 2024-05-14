package Animal;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Дружок");
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Рыжик");
        Cat[] cats = {cat1, cat2};
        Bowl bowl = new Bowl(30);
        animal1.run(123);
        animal1.swim(223);
        dog.run(500);
        dog.swim(4);
        cat1.run(134);
        cat1.swim(23);


        for (Cat cat : cats) {
            cat.eat(bowl, 20);
        }
        bowl.addFood(30);


        System.out.println("Количество котов: " + Cat.catCount);
        System.out.println("Количество собак: " + Dog.dogCount);
        System.out.println("Общее количество животных: " + Animal.animalCount);

        System.out.println("Состояние сытости котов:");
        System.out.println("Кот " + cat1.getName() + " сыт: " + cat1.isFull());
        System.out.println("Кот " + cat2.getName() + " сыт: " + cat2.isFull());
        for (Cat cat : cats) {
            System.out.println("Кот " + cat.getName() + " сытость: " + (cat.isFull() ? "сыт" : "голоден"));

        }
    }
}

