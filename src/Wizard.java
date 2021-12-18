/**
 *
 */
public class Wizard extends Heroe {

    /**
     * @param name: name of the hero
     */
    public Wizard(String name) {
        this.name = name;
        this.armor = new Protection("Armure en fer", 0.5, "armor");
        this.helmet = null;
        this.boots = new Protection("Bottes en cuir", 0.5, "boots");
        this.weapon = new Weapon("Épé en fer", 7.5);
        this.inventory = new Inventory();
    }

}