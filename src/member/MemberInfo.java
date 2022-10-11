package member;

public class MemberInfo {

	
	private String mid=null;
	private String mname=null;
	private String pass=null;
	private String addr=null;
	private int point=0;
	public String getId() {
		return mid;
	}
	public void setId(String id) {
		this.mid = id;
	}
	public String getName() {
		return mname;
	}
	public void setName(String name) {
		this.mname = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
