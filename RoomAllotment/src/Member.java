
public class Member {
	private int memberId;
	private String name;
	private Room room;
	public Member(int memberId, String name) {
		super();
		this.memberId = memberId;
		this.name = name;
	}
	public int getmId() {
		return memberId;
	}
	public String getName() {
		return name;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room r1) {
		this.room = r1;
		System.out.println("member ID:"+this.getmId());
		System.out.println("member Name:"+this.getName());
		System.out.println("member Room ID:"+this.getRoom().getRoomId());
	}
	


}
