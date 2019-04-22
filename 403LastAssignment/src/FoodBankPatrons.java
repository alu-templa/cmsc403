public class FoodBankPatrons {

    public static void main(String[] args) throws InterruptedException {
        FoodBank foodBank = new FoodBank();
        FoodProducer foodProducer = new FoodProducer(foodBank);
        FoodConsumer foodConsumer = new FoodConsumer(foodBank);

        foodProducer.start();
        foodConsumer.start();
        foodProducer.join();
        foodConsumer.join();
    }
}
