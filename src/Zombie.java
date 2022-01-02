/**
 *
 */
public class Zombie extends NPC {

    public static int INIT_HEALTH = 6;

    /**
     * @param name
     * @param health
     * @param damage
     */
    public Zombie(String name, double health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void resetHealth() {
        this.health = INIT_HEALTH;
    }
}