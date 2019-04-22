public class FoodBank {
    private int food;

    public FoodBank(){
        food = 0;
    }

    public void giveFood(int food){
        this.food += food;
    }
    public void takeFood(int food){
        this.food -= food;
    }

    public int getFood(){
        return this.food;
    }
}
