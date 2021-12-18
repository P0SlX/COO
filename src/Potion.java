/**
 *
 */
public class Potion implements Consumable {

    private String name;
    private String type;
    private double value;
    private int duration;

    /**
     * @param name:     name of the potion
     * @param type:     type of the potion
     * @param value:    value of the potion
     * @param duration: duration of the potion
     */
    public Potion(String name, String type, double value, int duration) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}