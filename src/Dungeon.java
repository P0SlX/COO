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
        // TODO implement here
    }

    /**
     *
     */
    public void enter() {
        // TODO implement here
    }

    /**
     *
     */
    public void leave() {
        // TODO implement here
    }

    /**
     *
     */
    public void nextRoom() {
        // TODO implement here
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