/**
 *
 */
public abstract class Heroe {

    protected String name;
    protected double health = 100.0;
    protected int money = 1000;
    protected double level = 0.0;
    protected double strength = 1.0;
    protected double intelligence = 1.0;
    protected double speed = 1.0;
    protected Protection armor;
    protected Protection helmet;
    protected Protection boots;
    protected Weapon weapon;
    protected Dungeon dungeon = null;
    protected Inventory inventory;

    /**
     * @param equipment: the equipment to equip
     */
    public void equipt(Equipment equipment) {
        if (equipment instanceof Protection) {
            switch (((Protection) equipment).getType()) {
                case "armor" -> this.armor = (Protection) equipment;
                case "helmet" -> this.helmet = (Protection) equipment;
                case "boots" -> this.boots = (Protection) equipment;
            }
        } else if (equipment instanceof Weapon) {
            this.weapon = (Weapon) equipment;
        }
    }

    /**
     * @param equipment: the equipment to unequipped
     */
    public void unequipped(String equipment) {
        switch (equipment) {
            case "armor" -> this.armor = null;
            case "helmet" -> this.helmet = null;
            case "boots" -> this.boots = null;
            case "weapon" -> this.weapon = null;
        }
    }

    /**
     * @param consumable: the consumable to use
     */
    public void use(Consumable consumable) {
        if (consumable instanceof Food) {
            this.health += ((Food) consumable).getHealth();
        }
    }

    /**
     * @param amount: the amount of damage to take
     */
    public void takeDamage(double amount) {
        this.health -= amount;
    }

    /**
     * @param npc: the npc to attack
     */
    public void attack(NPC npc) {
        npc.takeDamage(this.weapon.getDamage());
    }

}