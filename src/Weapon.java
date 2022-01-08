/**
 *
 */
public class Weapon implements Equipment {

    private String name;
    private double damage;
    private int price;

    /**
     * @param name:   name of the weapon
     * @param damage: damage of the weapon
     * @param price: price of the weapon
     */
    public Weapon(String name, double damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}