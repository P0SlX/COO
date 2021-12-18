/**
 *
 */
public class Food implements Consumable {

    private String name;
    private double health;

    /**
     * @param name:   name of the food
     * @param health: amount of health the food gives
     */
    public Food(String name, double health) {
        this.name = name;
        this.health = health;
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

}