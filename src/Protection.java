/**
 *
 */
public class Protection implements Equipment {

    private String name;
    private double armor;
    private String type;
    private int price;

    /**
     * @param name:  name of the protection
     * @param armor: protection bonus
     * @param type:  protection type
     * @param price: price of the protection
     */
    public Protection(String name, double armor, String type, int price) {
        this.name = name;
        this.armor = armor;
        this.type = type;
        this.price = price;
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

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}