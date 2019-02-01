package myspring.user.vo;

public class UserVO {
	
	private String userid;
	private String name;
	private String gender;
	private String city;
	
	public UserVO() {
		super();
	}
	
	public UserVO(String userid, String name, String gender, String city) {
		super();
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public void userInfo() {
		System.out.println("아이디 = ["+userid+"] 이름 = ["+name+"] 성별 = ["+gender+"] 도시 = ["+city+"]");
	}
	
}
