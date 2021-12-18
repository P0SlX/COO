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

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<Consumable> getConsumables() {
        return consumables;
    }

}