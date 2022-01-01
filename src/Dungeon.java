import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Dungeon {

    private String name;
    private Boolean present;
    private Room currentRoom;
    private List<Room> rooms;

    /**
     * @param name
     * @param generetedRooms
     */
    public Dungeon(String name, int generetedRooms) {
        this.name = name;

        this.rooms = new ArrayList<>();
        for (int i = 1; i <= generetedRooms; i++)
            this.rooms.add(new Room(i, i * 2, i * i, i * 1.5));

        this.present = false;
    }

    /**
     *
     */
    public void enter() {
        if (this.rooms.size() > 0) {
            this.present = true;
            this.currentRoom = this.rooms.get(0);
        } else
            System.out.println("Il n'y a pas de salle dans ce donjon.");
    }

    /**
     *
     */
    public void leave() {
        if (this.currentRoom == null)
            System.out.println("Vous n'êtes pas dans un donjon");
        else {
            this.present = false;
            this.currentRoom = null;
        }
    }

    /**
     *
     */
    public void nextRoom() {
        // Check si c'est la dernière room
        if (this.currentRoom == this.rooms.get(this.rooms.size() - 1)) {
            System.out.println("Vous avez fini le donjon ! Vous appercevez enfin la lumière du jour au loin.");
            System.out.println("... Vous voilà enfin sorti !");
        } else {
            // Passe à la room suivante
            this.currentRoom = this.rooms.get(this.currentRoom.getNumber() + 1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}