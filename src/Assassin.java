/**
 *
 */
public class Assassin extends Heroe {

    /**
     * @param name: name of the hero
     */
    public Assassin(String name) {
        this.name = name;
        this.armor = Game.PROTECTIONS[5];
        this.helmet = Game.PROTECTIONS[2];
        this.boots = Game.PROTECTIONS[8];
        this.weapon = Game.WEAPONS[0];
        this.inventory = new Inventory();
    }
}