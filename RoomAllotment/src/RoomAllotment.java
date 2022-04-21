import java.util.Scanner;


public class RoomAllotment {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int roomNo = 101;
		Scanner input = new Scanner(System.in);
		System.out.println("How many rooms you want create?");
		int roomSize = input.nextInt();
		//create room
		Room[] rooms = new Room[roomSize];
		for(int i=0;i<roomSize;i++)
		{
			rooms[i] = new Room(roomNo,4);
			roomNo += 100;
		}
		//create admin
		Admin admin = new Admin();
		
		//add member
		System.out.println("How many members you want add?");
		int memberSize = input.nextInt();
		
		for(int i=1;i<=memberSize;i++) {
			System.out.println("Member Name please !!");
			admin.assignRoom(rooms, new Member(i, input.next()));
		}
		
	}

}
