/**
 *
 */
public class Skeleton extends NPC {

    public static int INIT_HEALTH = 5;

    /**
     * @param name
     * @param health
     * @param damage
     */
    public Skeleton(String name, double health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void resetHealth() {
        this.health = INIT_HEALTH;
    }
}