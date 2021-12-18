/**
 *
 */
public class Protection implements Equipment {

    private String name;
    private double bonus;
    private String type;

    /**
     * @param name:  name of the protection
     * @param bonus: protection bonus
     * @param type:  protection type
     */
    public Protection(String name, double bonus, String type) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}