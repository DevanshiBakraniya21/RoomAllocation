import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class RoomAllotment {

	@SuppressWarnings({"unchecked", "resource" })
	public static void main(String[] args) throws IOException {
		int roomNo = 101;
		Scanner input = new Scanner(System.in);
		System.out.println("How many rooms you want create?");
		int roomSize = input.nextInt();
		//create room
		Room[] rooms = new Room[roomSize];
		for(int i=0;i<roomSize;i++)
		{
			System.out.println("Please enter room capacity:");
			rooms[i] = new Room(roomNo,input.nextInt());
			roomNo += 100;
		}
		//create admin
		Admin admin = new Admin();
		
		//add member
		System.out.println("How many members you want add?");
		int memberSize = input.nextInt();
		
		String fileName = "testSerialization.txt";
		
		//Saving of member objects in a file using serialization
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			//store all member objects into array list
			ArrayList<Member> mbrList = new ArrayList<>();
			for (int i = 1; i <= memberSize; i++) {
				System.out.println("Member Name please !!");
				mbrList.add(new Member(i, input.next()));
				System.out.println("Object has been serialized");
			}
			out.writeObject(mbrList);
			out.close();
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
       
         // Reading the member objects from a file using deserialization 
		try {
			FileInputStream file1 = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file1);
			ArrayList<Member> mbrObjList = new ArrayList<>();
			mbrObjList = (ArrayList<Member>) in.readObject();
			for (int i = 0; i < memberSize; i++) {
				//use synchronization concept when last memebr room allotment is pending
				if (i < memberSize-1) { 
					admin.assignRoom(rooms, mbrObjList.get(i));
				} else {
					//check which thread execute first
					SynchronizedClass s1 = new SynchronizedClass(rooms, mbrObjList.get(i));
					SynchronizedClass s2 = new SynchronizedClass(rooms, mbrObjList.get(i += 1));
					s1.start(); s2.start();
					try {
						s1.join(); s2.join();
					} catch (Exception e) {
						System.out.println("Thread Interrupted");
					}
				}
				System.out.println("Object has been deserialized ");
			}
			in.close();
			file1.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		
	}

}
