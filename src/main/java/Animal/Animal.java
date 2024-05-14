package Animal;

public class Animal {

    public static int animalCount = 0;
    private String name;


    public Animal(String name) {
        this.name = name;
        animalCount++;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println("Животное " + name + " пробежал " + distance + "м");
    }

    public void swim(int distance) {
        System.out.println("Животное " + name + " проплыл " + distance + "м");
    }
}

