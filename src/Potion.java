/**
 *
 */
public class Potion implements Consumable {

    private String name;
    private double health;

    /**
     * @param name:     name of the potion
     * @param health:    value of the potion
     */
    public Potion(String name, double health) {
        this.name = name;
        this.health = health;
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
}