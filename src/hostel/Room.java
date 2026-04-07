package hostel;

class Room {

    private int roomNo;
    private int capacity = 2;
    private int currentOccupancy = 0;

    static class RoomMetadata {

        static String hostelBlock = "D-Block, BITS Goa";
    }

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public void allocate() throws RoomFullException {
        if (currentOccupancy >= capacity) {
            throw new RoomFullException("Room " + roomNo + " is already full!");
        }
        currentOccupancy++;
        System.out.println("Student successfully allocated to Room " + roomNo);
    }
}
