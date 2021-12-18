/**
 *
 */
public class Weapon implements Equipment {

    private String name;
    private double damage;

    /**
     * @param name:   name of the weapon
     * @param damage: damage of the weapon
     */
    public Weapon(String name, double damage) {
        this.name = name;
        this.damage = damage;
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

}