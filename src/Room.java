import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Room {

    private int number;
    private double rewardXP;
    private int rewardMoney;
    private double difficulty;
    private List<NPC> npcs;

    /**
     * Default constructor
     */
    public Room(int number, double rewardXP, int rewardMoney, double difficulty) {
        this.number = number;
        this.rewardXP = rewardXP;
        this.rewardMoney = rewardMoney;
        this.difficulty = difficulty;

        this.npcs = new ArrayList<>();
        int nbChildClass = 3;   // Nombre de classes de NPC (à augmenter/diminuer si le nombre de classes change)

        for (int i = 0; i < difficulty; i++) {
            int choice = (int) Math.floor(Math.random() * nbChildClass);
            String name = Game.NAMES[(int) Math.floor(Math.random() * 20)]; // On va prendre un nom aléatoire

            switch (choice) {
                // Peut être multiplier la vie/dégat en fonction de la difficulté ?
                // À voir comment équilibrer ca après...
                case 0 -> this.npcs.add(new Bunny(name, 3, 1));
                case 1 -> this.npcs.add(new Skeleton(name, 5, 3));
                case 2 -> this.npcs.add(new Zombie(name, 6, 5));
            }
        }
    }

    public boolean isRoomFinished() {
        for (NPC npc : this.npcs)
            if (npc.getHealth() > 0)
                return false;
        return true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getRewardXP() {
        return rewardXP;
    }

    public void setRewardXP(double rewardXP) {
        this.rewardXP = rewardXP;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(int rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }
}