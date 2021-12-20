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
                case "armor" -> armor = (Protection) equipment;
                case "helmet" -> helmet = (Protection) equipment;
                case "boots" -> boots = (Protection) equipment;
            }
        } else if (equipment instanceof Weapon) {
            weapon = (Weapon) equipment;
        }
    }

    /**
     * @param equipment: the equipment to unequipped
     */
    public void unequipped(String equipment) {
        switch (equipment) {
            case "armor" -> armor = null;
            case "helmet" -> helmet = null;
            case "boots" -> boots = null;
            case "weapon" -> weapon = null;
        }
    }

    /**
     * @param consumable: the consumable to use
     */
    public void use(Consumable consumable) {
        if (consumable instanceof Food) {
            health += ((Food) consumable).getHealth();
        }
    }

    /**
     * @param amount: the amount of damage to take
     */
    public void takeDamage(double amount) {
        health -= amount;
    }

    /**
     * @param npc: the npc to attack
     */
    public void attack(NPC npc) {
        npc.takeDamage(weapon.getDamage());
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Protection getArmor() {
        return armor;
    }

    public void setArmor(Protection armor) {
        this.armor = armor;
    }

    public Protection getHelmet() {
        return helmet;
    }

    public void setHelmet(Protection helmet) {
        this.helmet = helmet;
    }

    public Protection getBoots() {
        return boots;
    }

    public void setBoots(Protection boots) {
        this.boots = boots;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Inventory getInventory() {
        return inventory;
    }

}