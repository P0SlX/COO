/**
 *
 */
public class Assassin extends Heroe {

    /**
     * @param name: name of the hero
     */
    public Assassin(String name) {
        this.name = name;
        this.armor = new Protection("Armure en cuir", 0.5, "armor");
        this.helmet = new Protection("Casque en cuir", 0.5, "helmet");
        this.boots = new Protection("Bottes en cuir", 0.5, "boots");
        this.weapon = new Weapon("Dague en fer", 10.0);
        this.inventory = new Inventory();
    }

}