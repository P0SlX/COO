/**
 *
 */
public abstract class Heroe {

    protected String name;
    protected double health;
    protected int money;
    protected double level;
    protected double strength;
    protected double intelligence;
    protected double speed;
    protected Protection armor;
    protected Protection helmet;
    protected Protection boots;
    protected Weapon weapon;
    protected Dungeon dungeon;
    protected Inventory inventory;

    /**
     * @param equipment
     */
    public void equipt(Equipment equipment) {
        // TODO implement here
    }

    /**
     * @param equipment
     */
    public void unequipped(Equipment equipment) {
        // TODO implement here
    }

    /**
     * @param consumable
     */
    public void use(Consumable consumable) {
        // TODO implement here
    }

    /**
     * @param amount
     */
    public void takeDamage(double amount) {
        // TODO implement here
    }

    /**
     * @param npc
     */
    public void attack(NPC npc) {
        // TODO implement here
    }

}