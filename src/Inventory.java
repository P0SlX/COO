import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Inventory {

    private final List<Equipment> equipments;
    private final List<Consumable> consumables;

    /**
     * Default constructor
     */
    public Inventory() {
        equipments = new ArrayList<>();
        consumables = new ArrayList<>();
    }

    /**
     * @param obj: Equipment or Consumable
     */
    public void add(Object obj) {
        if (obj instanceof Equipment) {
            equipments.add((Equipment) obj);
        } else if (obj instanceof Consumable) {
            consumables.add((Consumable) obj);
        }
    }

    /**
     * @param obj: Equipment or Consumable
     */
    public void remove(Object obj) {
        if (obj instanceof Equipment) {
            equipments.remove(obj);
        } else if (obj instanceof Consumable) {
            consumables.remove(obj);
        }
    }

    public void divide() {
        for (int i = 0; i < this.equipments.size(); i++)
            if (i % 2 == 0)
                this.remove(this.equipments.get(i));

        for (int i = 0; i < this.consumables.size(); i++)
            if (i % 2 == 0)
                this.remove(this.consumables.get(i));

    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<Consumable> getConsumables() {
        return consumables;
    }

}