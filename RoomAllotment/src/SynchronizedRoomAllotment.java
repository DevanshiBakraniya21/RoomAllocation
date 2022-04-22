import java.util.Scanner;

public class SynchronizedRoomAllotment {

	public static void main(String[] args) {
		//create room
		Room[] rooms = new Room[1];
		rooms[0] = new Room(101,4);
		
		//create admin
		Admin admin = new Admin();
		
		//add member
		int i=1;
		admin.assignRoom(rooms, new Member(i, "devanshi1"));
		admin.assignRoom(rooms, new Member(i+=1,"devanshi2"));
		admin.assignRoom(rooms, new Member(i+=1,"devanshi3"));
		
		boolean isTrue=true;
		while(isTrue) {
			SynchronizedClass s1= new SynchronizedClass(rooms, new Member(i+=1,"devanshi4"));
			SynchronizedClass s2= new SynchronizedClass(rooms, new Member(i+=1,"devanshi5"));
			SynchronizedClass s3= new SynchronizedClass(rooms, new Member(i+=1,"devanshi6"));
		
			 s1.start(); s2.start(); s3.start();
			 
			 try { 
				 s1.join(); s2.join(); s3.join();
			 }catch(Exception e) {
				 System.out.println("Thread Interrupted");
			 } 
			 isTrue=false;
		}
	
	}

}
