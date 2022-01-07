/**
 *
 */
public class Barbarian extends Heroe {

    /**
     * @param name: name of the hero
     */
    public Barbarian(String name) {
        this.name = name;
        this.armor = Game.PROTECTIONS[3];
        this.helmet = Game.PROTECTIONS[0];
        this.boots = Game.PROTECTIONS[6];
        this.weapon = Game.WEAPONS[1];
        this.inventory = new Inventory();
    }

}