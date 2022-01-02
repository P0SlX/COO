import java.util.List;

public class Fight {

    private Heroe heroe;
    private List<NPC> npcs;

    public Fight(Heroe heroe, List<NPC> npcs) {
        this.heroe = heroe;
        this.npcs = npcs;
    }

    public void heroeAttackNPC(int index) {
        this.heroe.attack(this.npcs.get(index));
    }

    public void NPCsAttackHeroe() {
        for (NPC npc: this.npcs)
            if (npc.getHealth() > 0)
                npc.attack(this.heroe);
    }
}
