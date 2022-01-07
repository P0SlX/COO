/**
 *
 */
public class Protection implements Equipment {

    private String name;
    private double armor;
    private String type;

    /**
     * @param name:  name of the protection
     * @param armor: protection bonus
     * @param type:  protection type
     */
    public Protection(String name, double armor, String type) {
        this.name = name;
        this.armor = armor;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}