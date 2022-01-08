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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\nVos équipements :\n| ");
        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            res.append("(").append(i + 1).append(") ").append(equipment.getName()).append(" | ");
        }

        res.append("\nVos consommables :\n| ");
        for (int i = 0; i < consumables.size(); i++) {
            Consumable consumable = consumables.get(i);
            res.append("(").append(i + 1).append(") ").append(consumable.getName()).append(" | ");
        }
        return res.toString();
    }
}