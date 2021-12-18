/**
 *
 */
public class Barbarian extends Heroe {

    /**
     * @param name: name of the hero
     */
    public Barbarian(String name) {
        this.name = name;
        this.armor = new Protection("Armure en acier", 1.0, "armor");
        this.helmet = new Protection("Casque en acier", 1.0, "helmet");
        this.boots = new Protection("Bottes en acier", 1.0, "boots");
        this.weapon = new Weapon("Hache en fer", 5.0);
        this.inventory = new Inventory();
    }

}