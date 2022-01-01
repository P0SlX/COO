/**
 *
 */
public abstract class NPC {

    protected String name;
    protected double health;
    protected double damage;

    /**
     *
     */
    public void attack(Heroe heroe) {
        heroe.takeDamage(damage);
    }

    /**
     * @param amount
     */
    public void takeDamage(double amount) {
        if (this.health < amount)
            this.health = 0;
        else
            this.health -= amount;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }
}