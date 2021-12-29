import java.util.List;

/**
 *
 */
public class Room {

    private int number;
    private double rewardXP;
    private int rewardMoney;
    private double difficulty;
    private Boolean finished;
    private List<NPC> npcs;

    /**
     * Default constructor
     */
    public Room(int number, double rewardXP, int rewardMoney, double difficulty) {
        this.number = number;
        this.rewardXP = rewardXP;
        this.rewardMoney = rewardMoney;
        this.difficulty = difficulty;
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

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }
}