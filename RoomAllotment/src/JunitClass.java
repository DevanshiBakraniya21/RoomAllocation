import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JunitClass {
	@BeforeAll
	static void before() {
		System.out.println("start");
		Scanner input = new Scanner(System.in);
		System.out.println("Room counter value");
		int roomCounter = input.nextInt();
		Room.setCounter(roomCounter);
		
		//4.assert check roomCounter is not less then 0 
		assertFalse(roomCounter<0);
	}
	
	@Test
	void test() {
		int roomNo = 101;
		Scanner input = new Scanner(System.in);
		System.out.println("How many rooms you want create?");
		int roomSize = input.nextInt();
		//1.assert check roomsize is not less then 0 or 0
		assertFalse(roomSize<=0);
		
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
		
		//2.assert check memberSize is not less then 0 or 0
		assertFalse(memberSize<=0);
		
		for(int i=1;i<=memberSize;i++) {
			System.out.println("Member Name please !!");
			String name = input.next();
			/*
			 * if(i==memberSize-1) { //3.member name is null
			 *  name = null;
			 * assertNotNull(name); }
			 */
			//3.member name is not null
			assertNotNull(name);
			admin.assignRoom(rooms, new Member(i, name));
		}
		
	}
	
	@AfterAll
	static void after() {
		int roomCounter = Room.getCounter();
		assertTrue(roomCounter!=0);
		System.out.println("completed");
	}
}
