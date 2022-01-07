/**
 *
 */
public class Wizard extends Heroe {

    /**
     * @param name: name of the hero
     */
    public Wizard(String name) {
        this.name = name;
        this.armor = Game.PROTECTIONS[4];
        this.helmet = null;
        this.boots = Game.PROTECTIONS[8];
        this.weapon = Game.WEAPONS[2];
        this.inventory = new Inventory();
    }

}