/**
 *
 */
public abstract class NPC {

    public static int INIT_HEALTH = -1;

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

    // Permet juste d'avoir accès à resetHealth() des méthodes filles
    // Il met la vie a -1 pour pouvoir debugger plus facilement si d'autres
    // classes de NPC sont ajoutés.
    public void resetHealth() {
        this.health = INIT_HEALTH;
    }
}