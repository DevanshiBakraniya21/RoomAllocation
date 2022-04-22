
public class SynchronizedClass extends Thread{
	private Room[] rooms;
	private Member member;
	public SynchronizedClass(Room[] rooms, Member member) {
		super();
		this.rooms = rooms;
		this.member = member;
	}
	//create admin
	Admin admin = new Admin();
	public void run() {
		synchronized (rooms) {
			System.out.println(Thread.currentThread());
			admin.assignRoom(rooms, member);
		}
	}
}
