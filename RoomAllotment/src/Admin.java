
public class Admin {
	public void assignRoom(Room[] rooms,Member member) {
		int roomSize = rooms.length;
		int counter = Room.getCounter();
		int capacity = 4;
		int totalCapacity = roomSize * capacity;
		//check room available or not
		if(counter < totalCapacity) {
			//check which room is empty
			int roomIndex = 0 ;
			counter+=1;
			for(int i=1; i <= roomSize && roomIndex == 0;i++) {
				if(counter <= (capacity*i)) {
					roomIndex = i;
				}
			}
			//allocate room
			member.setRoom(rooms[roomIndex - 1]);
			//update counter 
			Room.setCounter(counter);
		}else {
			System.err.println("Sorry Room not available");
		}
	}
}
