/**
 *
 */
public class Food implements Consumable {

    private String name;
    private double health;
    private int price;

    /**
     * @param name:   name of the food
     * @param health: amount of health the food gives
     * @param price:  price of the food
     */
    public Food(String name, double health, int price) {
        this.name = name;
        this.health = health;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}