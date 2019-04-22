import java.util.Random;

public class FoodConsumer extends Thread {
    private FoodBank foodBank;

    public FoodConsumer(FoodBank bank) {
        this.foodBank = bank;
    }

    @Override
    public void run() {
        try {
        Random random = new Random();
        int consumedFood;
        int foodBalance;
        while (true) {
            synchronized (this) {

                consumedFood = random.nextInt(100) + 1;
                foodBalance = foodBank.getFood();

                consume(foodBank, consumedFood, foodBalance);

            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void consume(FoodBank foodBank, int consumedFood, int foodBalance) throws InterruptedException {
        if (consumedFood > foodBalance) {
            System.out.println("Waiting to get food");
            notify();
        } else {
            foodBank.takeFood(consumedFood);
            foodBalance = foodBank.getFood();
            System.out.printf("Taking %d items of food, the balance is now %d items;\n", consumedFood, foodBalance);
            notify();
            Thread.sleep(1000);
        }
    }
}