
public class Room {
	private int roomId;
	private int capacity;
	private static int counter;
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Room.counter = counter;
		System.out.println("Room Counter:"+counter);
	}
	public Room(int roomId, int capacity) {
		super();
		this.roomId = roomId;
		this.capacity = capacity;
	}
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
}
