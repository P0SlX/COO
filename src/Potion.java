/**
 *
 */
public class Potion implements Consumable {

    private String name;
    private double health;
    private int price;

    /**
     * @param name:     name of the potion
     * @param health:    value of the potion
     * @param price:    price of the potion
     */
    public Potion(String name, double health, int price) {
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

    @Override
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