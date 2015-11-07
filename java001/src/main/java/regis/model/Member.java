package regis.model;

public class Member {
	private long id;
    String memberName;
    String memberPs;
    String memberEmail;

	public Member(long key) {
		id = key;
	}
	
	public Member(String memberName, String memberPs, String memberEmail) {
		super();
		this.memberName = memberName;
		this.memberPs = memberPs;
		this.memberEmail = memberEmail;

	}
	
	public Member(long id, String memberName, String memberPs, String memberEmail) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.memberPs = memberPs;
		this.memberEmail = memberEmail;

	}

	public Member() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getmemberPs() {
		return memberPs;
	}
	public void setmemberPs(String memberPs) {
		this.memberPs = memberPs;
	}
	public String getmemberEmail() {
		return memberEmail;
	}
	public void setmemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

    
}
