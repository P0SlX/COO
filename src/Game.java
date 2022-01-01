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

    public static String[] NAMES = {"Drivreni", "Ogazdik", "Vomonnak", "Drevoh", "Tondagen", "Jendal", "Ergolor", "Petlar", "Ersalor", "Ellar", "Rezdil", "Dranbah", "Lenbul", "Vunnezot", "Zazza", "Bolmil", "Liagwyn", "Zylynore", "Orisatra", "Zylrora"};

    private Dungeon dungeon;
    private Heroe heroe;

    /**
     * Default constructor
     */
    public Game() {
        dungeon = new Dungeon("444 Nuits", 5);
        heroe = null;
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
        System.out.println("Affichage Inventaire");
//        System.out.println("\nVotre inventaire :");
//        for (Equipment item : heroe.getInventory().getEquipments()) {
//            System.out.println(item.getName());
//        }
//        for (Consumable item : heroe.getInventory().getConsumables()) {
//            System.out.println(item.getName());
//        }
    }

    private void displayNPCInRoom() {
        System.out.println("\n  PNJ(s) restant(s) :");
        Room currentRoom = this.dungeon.getCurrentRoom();

        // TODO
        //  Faire un meilleur affichage que ca...
        for (int i = 0; i < currentRoom.getNpcs().size(); i++) {
            NPC npc = currentRoom.getNpcs().get(i);

            System.out.print(i + 1 + ". " + npc.getName());

            for (int j = 0; j < 8 - npc.getName().length(); j++) {  // Pour équilibrer les espaces
                System.out.print(" ");
            }

            if (npc instanceof Zombie)
                System.out.println("  |  Zombie  |  Vie : " + npc.getHealth());
            else if (npc instanceof Skeleton)
                System.out.println("  |  Squelette  |  Vie : " + npc.getHealth());
            else if (npc instanceof Bunny)
                System.out.println("  |  Lapin  |  Vie : " + npc.getHealth());
        }
    }

    private void displayHeroeInfo() {
        // TODO
//        System.out.println(this.heroe.getName());
    }

    private boolean isRoomFinished() {
        for (NPC npc : this.dungeon.getCurrentRoom().getNpcs())
            if (npc.getHealth() > 0)
                return false;
        return true;
    }

    public void inFight() {
        while (!this.isRoomFinished()) {
            // TODO
            //  Faire un StringBuilder, et calculer centrer les sous-titres en dessous des titres
            System.out.println("\n---- Donjon " + this.dungeon.getName() + " / Salle " + this.dungeon.getCurrentRoom().getNumber() + " ----");
            System.out.println("  Phase de combat");
            this.displayNPCInRoom();
            System.out.println("\n  Quel PNJ souhaitez-vous attaquer ?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            // TODO
        }

    }

    public void mainMenu() {
        int choice;
        while (true) {
            System.out.println("\n---- Menu principal ----\n");
            System.out.println(" 1. Afficher l'inventaire");
            System.out.println(" 2. Rentrer dans le donjon");
            System.out.println(" 3. Quitter le jeu");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1 -> this.viewInventory();
                case 2 -> {
                    this.dungeon.enter();
                    this.inFight();
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Veuillez faire un choix valide.");
            }
        }
    }
}