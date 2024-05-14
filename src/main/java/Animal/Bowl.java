package Animal;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя добавить отрицательное количество корма");
            return;
        }
        foodAmount += amount;
        System.out.println("Добавлено " + amount + " корма в миску");
    }

    public void decreaseFood(int amount) {
        if (amount > foodAmount) {
            System.out.println("Недостаточно корма в миске");
            return;
        }
        foodAmount -= amount;
        System.out.println("Съедено " + amount + " корма из миски");
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

