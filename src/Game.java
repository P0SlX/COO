import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class Game {

    public static Weapon[] WEAPONS = {
            new Weapon("Dague en fer", 10.0, 150),
            new Weapon("Hache en fer", 5.0, 75),
            new Weapon("Épé en fer", 7.5, 100)
    };

    // 9
    public static Protection[] PROTECTIONS = {
            new Protection("Casque en acier", 0.5, "helmet", 500),
            new Protection("Casque en fer", 0.7, "helmet", 250),
            new Protection("Casque en cuir", 0.9, "helmet", 100),

            new Protection("Armure en acier", 0.5, "armor", 500),
            new Protection("Armure en fer", 0.7, "armor", 250),
            new Protection("Armure en cuir", 0.9, "armor", 100),

            new Protection("Bottes en acier", 0.5, "boots", 500),
            new Protection("Bottes en fer", 0.7, "boots", 250),
            new Protection("Bottes en cuir", 0.9, "boots", 100),
    };

    // 9
    public static Food[] FOODS = {
            new Food("Pomme", 5, 10),
            new Food("Tartelette", 30, 60),
            new Food("Tuc", 1, 2),
            new Food("Snickers", 10, 20),
            new Food("Pizza du Crous", 25, 50),
            new Food("Canette", 7, 14),
            new Food("Beignet", 8, 16),
            new Food("Donut", 7, 14),
            new Food("Couscous", 40, 80)
    };

    // 8
    public static Potion[] POTIONS = {
            new Potion("Potion du Crous", 1, 2),
            new Potion("Potion de base", 10, 20),
            new Potion("Potion de base ++", 11, 22),
            new Potion("Potion Plus", 20, 40),
            new Potion("Potion Premium", 30, 60),
            new Potion("Potion Max", 40, 80),
            new Potion("Potion Pro Max", 50, 100),
            new Potion("Potion Pro Max X", 100, 200),
    };

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
        this.heroe.inventory.add(POTIONS[0]);
        this.heroe.inventory.add(POTIONS[1]);
        this.heroe.inventory.add(FOODS[4]);
    }

    /**
     *
     */
    public void viewInventory() throws InterruptedException {
        this.clearScreen();
        Inventory inventory = this.heroe.getInventory();
        List<Equipment> equipments = inventory.getEquipments();
        List<Consumable> consumables = inventory.getConsumables();


        int choice = 0;
        while (choice != 1 && choice != 2 && choice != 3) {
            // Inventaire vide
            if (equipments.size() == 0 && consumables.size() == 0) {
                System.out.println("Votre inventaire est vide.");
                Thread.sleep(1500);
                return;
            }

            this.displayHeroeInfo();
            System.out.println(inventory);

            System.out.println("\n\n1. Équiper un équipement");
            System.out.println("2. Utiliser un consommable");
            System.out.println("3. Jeter un équipement");
            System.out.println("4. Jeter un consommable");
            System.out.println("5. Quitter l'inventaire");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            if (choice > 0 && choice < 5)
                System.out.print("Numéro : ");
            else if (choice == 5)
                return;

            try {
                switch (choice) {
                    case 1 -> this.heroe.equipt(equipments.get((new Scanner(System.in).nextInt()) - 1));
                    case 2 -> this.heroe.use(consumables.get((new Scanner(System.in).nextInt()) - 1));
                    case 3 -> this.heroe.inventory.getEquipments().remove(equipments.get((new Scanner(System.in).nextInt()) - 1));
                    case 4 -> this.heroe.inventory.getConsumables().remove(consumables.get((new Scanner(System.in).nextInt()) - 1));
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Objet inexistant...");
            }
            choice = 0;
        }
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
        System.out.println("Héro: " + this.heroe.getName() + " | " + this.heroe.getHealth() + " PV | Niveau " + (int) this.heroe.getLevel() + " | Argent: " + this.heroe.getMoney());
        System.out.println("\nArme : " + (this.heroe.getWeapon() == null ? "Aucune" : this.heroe.getWeapon().getName()));
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
        this.heroe.setMoney(dungeon.getCurrentRoom().getRewardMoney() + this.heroe.getMoney());
        this.heroe.setLevel(dungeon.getCurrentRoom().getRewardXP() + this.heroe.getLevel());
        int choice2 = 0;
        while (choice2 != 1 && choice2 != 2 && choice2 != 3) {
            System.out.println("\n1. Salle suivante");
            System.out.println("2. Voir l'inventaire");
            System.out.println("3. Sortir du donjon");
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

    private void reward() {
        this.heroe.inventory.add(FOODS[ThreadLocalRandom.current().nextInt(0, FOODS.length)]);
        this.heroe.inventory.add(POTIONS[ThreadLocalRandom.current().nextInt(0, POTIONS.length)]);
        this.heroe.inventory.add(POTIONS[ThreadLocalRandom.current().nextInt(0, POTIONS.length)]);
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
        this.reward();
        this.dungeon.reset();
    }

    private void shop() {
        int choice = 0;
        while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
            this.clearScreen();
            System.out.println("\n====================");
            System.out.print("Argent : " + this.heroe.getMoney());
            System.out.println(this.heroe.inventory);
            System.out.println("\n====================");

            System.out.print("\n\nArmes :\n| ");
            for (int i = 0; i < WEAPONS.length; i++) {
                if (i % 3 == 0 && i != 0)
                    System.out.print("\n| ");
                System.out.print("(" + (i + 1) + ") " + WEAPONS[i].getName() + " (" + WEAPONS[i].getDamage() + " pts de dégats) | ");
            }

            System.out.print("\n\nProtections :\n| ");
            for (int i = 0; i < PROTECTIONS.length; i++) {
                if (i % 3 == 0 && i != 0)
                    System.out.print("\n| ");
                System.out.print("(" + (i + 1) + ") " + PROTECTIONS[i].getName() + " (" + PROTECTIONS[i].getArmor() + "x) | ");
            }

            System.out.print("\n\nNourriture :\n| ");
            for (int i = 0; i < FOODS.length; i++) {
                if (i % 3 == 0 && i != 0)
                    System.out.print("\n| ");
                System.out.print("(" + (i + 1) + ") " + FOODS[i].getName() + " (+" + FOODS[i].getHealth() + "PV) | ");
            }

            System.out.print("\n\nPotions :\n| ");
            for (int i = 0; i < POTIONS.length; i++) {
                if (i % 3 == 0 && i != 0)
                    System.out.print("\n| ");
                System.out.print("(" + (i + 1) + ") " + POTIONS[i].getName() + " (" + POTIONS[i].getHealth() + "x) | ");
            }

            System.out.println("\n\n1. Acheter une arme");
            System.out.println("2. Acheter une protection");
            System.out.println("3. Acheter de la nourriture");
            System.out.println("4. Acheter une potion");
            System.out.println("5. Sortir de chez le marchand");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            if (choice > 0 && choice < 5)
                System.out.print("Numéro : ");
            else if (choice == 5)
                return;

            try {
                int index = (new Scanner(System.in).nextInt()) - 1;
                switch (choice) {
                    case 1 -> {
                        this.heroe.inventory.add(WEAPONS[index]);
                        this.heroe.setMoney(this.heroe.getMoney() - WEAPONS[index].getPrice());
                    }
                    case 2 -> {
                        this.heroe.inventory.add(PROTECTIONS[index]);
                        this.heroe.setMoney(this.heroe.getMoney() - PROTECTIONS[index].getPrice());
                    }
                    case 3 -> {
                        this.heroe.inventory.add(FOODS[index]);
                        this.heroe.setMoney(this.heroe.getMoney() - FOODS[index].getPrice());
                    }
                    case 4 -> {
                        this.heroe.inventory.add(POTIONS[index]);
                        this.heroe.setMoney(this.heroe.getMoney() - POTIONS[index].getPrice());
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Objet inexistant...");
            }
            choice = 0;
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
            System.out.println(" 3. Aller chez le marchand");
            System.out.println(" 4. Quitter le jeu");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1 -> this.viewInventory();
                case 2 -> {
                    this.dungeon.enter();
                    this.inDungeon();
                }
                case 3 -> this.shop();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Veuillez faire un choix valide.");
            }
        }
    }
}