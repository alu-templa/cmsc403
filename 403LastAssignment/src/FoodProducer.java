import java.util.Random;

public class FoodProducer extends Thread {
    private FoodBank foodBank;

    public FoodProducer(FoodBank bank) {
        this.foodBank = bank;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int producedFood;

            while (true) {
                synchronized (this) {

                    producedFood = random.nextInt(100) + 1;

                    produce(foodBank, producedFood);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void produce(FoodBank foodBank, int producedFood) throws InterruptedException {
        foodBank.giveFood(producedFood);
        int foodBalance = foodBank.getFood();
        System.out.printf("Producing %d items of food, the balance is now %d items;\n", producedFood, foodBalance);
        notify();
        Thread.sleep(1000);
    }
}
