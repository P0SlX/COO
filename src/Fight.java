import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Fight {

    private Heroe heroe;
    private List<NPC> npcs;

    public Fight(Heroe heroe, List<NPC> npcs) {
        this.heroe = heroe;
        this.npcs = npcs;
    }

    public void heroeAttackNPC(int index) {
        NPC npc = this.npcs.get(index);
        this.heroe.attack(npc);

        if (npc.getHealth() <= 0) {
            double xp = ThreadLocalRandom.current().nextDouble(0.1, 0.59);
            int money = ThreadLocalRandom.current().nextInt(25, 151);
            this.heroe.setLevel(this.heroe.getLevel() + xp);
            this.heroe.setMoney(this.heroe.getMoney() + money);
        }
        // TODO
        //  Drop d'item aléatoirement
    }

    public void NPCsAttackHeroe() {
        for (NPC npc : this.npcs)
            if (npc.getHealth() > 0)
                npc.attack(this.heroe);
    }
}
