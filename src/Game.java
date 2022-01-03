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
        this.clearScreen();
        // TODO
        //  Afficher les stats de chaque perso
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
    // TODO
    public void viewInventory() throws InterruptedException {
        Inventory inventory = this.heroe.getInventory();
        List<Equipment> equipments = inventory.getEquipments();
        List<Consumable> consumables = inventory.getConsumables();

        // Inventaire vide
        if (equipments.size() == 0 && consumables.size() == 0) {
            System.out.println("Votre inventaire est vide.");
            Thread.sleep(2000);
            return;
        }

        System.out.println("\nVos équipements :");
        for (Equipment item : equipments) {
            System.out.println(item.getName() + " | ");
        }

        System.out.println("\nVos consommables :");
        for (Consumable item : consumables) {
            System.out.println(item.getName() + " | ");
        }

//        Thread.sleep(15000);
    }

    private void clearScreen() {
        for (int i = 0; i < 50; i++)
            System.out.println("\n");
    }

    private void displayNPCInRoom() {
        System.out.println("\nPNJ(s) restant(s) :");
        Room currentRoom = this.dungeon.getCurrentRoom();

        // TODO
        //  Faire un meilleur affichage que ca...
        for (int i = 0; i < currentRoom.getNpcs().size(); i++) {
            NPC npc = currentRoom.getNpcs().get(i);

            if (npc.getHealth() <= 0)
                continue;

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
        System.out.println("Héro: " + this.heroe.getName() + " | " + this.heroe.getHealth() + " PV | Niveau " + (int)this.heroe.getLevel() + " | Argent: " + this.heroe.getMoney());
        System.out.println();
        System.out.println("Armure : ");
        System.out.println("  - Casque : " + (this.heroe.getHelmet() == null ? "Aucun" : this.heroe.getHelmet().getName()));
        System.out.println("  - Plastron : " + (this.heroe.getArmor() == null ? "Aucun" : this.heroe.getArmor().getName()));
        System.out.println("  - Jambières : " + (this.heroe.getBoots() == null ? "Aucune" : this.heroe.getBoots().getName()));
    }

    private boolean isDungeonFinished() {
        // Si c'est la dernière pièce
        if (this.dungeon.getCurrentRoom() == this.dungeon.getRooms().get(this.dungeon.getRooms().size() - 1))
            return this.dungeon.getCurrentRoom().isRoomFinished();
        return false;
    }

    private boolean roomFinished() throws InterruptedException {
        int choice2 = 0;
        while (choice2 != 1 && choice2 != 2 && choice2 != 3) {
            System.out.println("oui");
            Scanner input2 = new Scanner(System.in);
            choice2 = input2.nextInt();
            switch (choice2) {
                case 1 -> this.dungeon.nextRoom();
                case 2 -> {
                    this.viewInventory();
                    choice2 = 0;    // Pour retourner à ce menu une fois l'inventaire consulté
                }
                case 3 -> {
                    this.dungeon.reset();
                    return true;
                }
            }
        }
        return false;
    }

    public void inDungeon() throws InterruptedException {
        while (!this.isDungeonFinished()) {
            this.clearScreen();

            System.out.println("\n---- Donjon " + this.dungeon.getName() + " / Salle " + this.dungeon.getCurrentRoom().getNumber() + " ----");
            this.displayHeroeInfo();
            this.displayNPCInRoom();

            System.out.println("\n  Quel PNJ souhaitez-vous attaquer ?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt() - 1;

            // Phase d'attaque
            Fight fight = new Fight(this.heroe, this.dungeon.getCurrentRoom().getNpcs());
            fight.heroeAttackNPC(choice);
            fight.NPCsAttackHeroe();

            // Si le héro meurt, on reset le donjon à son état initial
            // On pert une partie de l'inventaire
            // Et on met le héro à 1PV
            if (this.heroe.getHealth() <= 0) {
                this.clearScreen();
                System.out.println("\nVous êtes mort... ");
                Thread.sleep(1500);
                System.out.println("Votre corps est transporté hors du donjon et vous avez perdu la moitié de votre inventaire.");
                Thread.sleep(4000);
                this.dungeon.reset();
                this.heroe.getInventory().divide();
                this.heroe.setHealth(1.0);
                return;
            }

            // Choix possibles lorsque la pièce est finie.
            if (this.dungeon.getCurrentRoom().isRoomFinished())
                if (this.roomFinished())
                    return;
        }
    }

    public void mainMenu() throws InterruptedException {
        int choice;
        while (true) {
            this.clearScreen();
            System.out.println("\n---- Menu principal ----");
            this.displayHeroeInfo();
            System.out.println("\n 1. Afficher l'inventaire");
            System.out.println(" 2. Rentrer dans le donjon");
            System.out.println(" 3. Quitter le jeu");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1 -> this.viewInventory();
                case 2 -> {
                    this.dungeon.enter();
                    this.inDungeon();
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Veuillez faire un choix valide.");
            }
        }
    }
}