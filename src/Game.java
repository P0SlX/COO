import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Game {

    public static Map<String, Double> WEAPONS = Map.of("Dague en fer", 10.0, "Hache en fer", 5.0, "Épé en fer", 7.5);

    public static Map<String, Map<String, Object>> PROTECTIONS;

    public static Map<String, Map<String, Object>> FOODS;

    public static Map<String, Map<String, Object>> POTIONS;

    private List<Dungeon> dungeons;
    private Heroe heroe;

    /**
     * Default constructor
     */
    public Game() {
        dungeons = new ArrayList<>();
        heroe = null;
    }

    /**
     * @param dungeons: List of dungeon names
     */
    public void dungeonGeneration(List<String> dungeons) {
        for (String dungeonName : dungeons) {
            this.dungeons.add(new Dungeon(dungeonName, (int) (Math.random() * (3 - 8 + 1) + 8)));
        }
    }

    /**
     *
     */
    public void heroeCreation() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nVeuillez choisir un nom pour votre héro");
        String heroeName = input.nextLine();
        System.out.println("\nVeuillez choisir votre classe\n   1. Assassin\n   2. Sorcier\n   3. Barbare");
        int heroeClass = 0;
        while (heroeClass != 1 && heroeClass != 2 && heroeClass != 3) {
            heroeClass = input.nextInt();
            switch (heroeClass) {
                case 1 -> heroe = new Assassin(heroeName);
                case 2 -> heroe = new Wizard(heroeName);
                case 3 -> heroe = new Barbarian(heroeName);
                default -> System.out.println("\nVeuillez choisir une classe valide\n   1. Assassin\n   2. Sorcier\n   3. Barbare");
            }
        }
    }

    /**
     *
     */
    public void viewInventory() {
        /*System.out.println("\nVotre inventaire :");
        for (Equipment item : heroe.getInventory().getEquipments()) {
            System.out.println(item.getName());
        }
        for (Consumable item : heroe.getInventory().getConsumables()) {
            System.out.println(item.getName());
        }*/
    }

    /**
     *
     */
    public void chooseDungeon() {
        Scanner input = new Scanner(System.in);
        int dungeonId = 0;
        while (dungeonId < 1 || dungeonId > dungeons.size()) {
            System.out.println("\nDans quel donjon voulez-vous aller ?");
            int id = 1;
            for (Dungeon dungeon : dungeons) {
                System.out.println("\n   " + id + ". " + dungeon.getName());
            }
            dungeonId = input.nextInt();
            // TODO: Faire entrer le héro dans le donjon
        }
    }

}