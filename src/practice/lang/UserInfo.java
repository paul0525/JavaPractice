package practice.lang;

public class UserInfo {

	private long userId;
	
	private String userName;
	
	private String pwd;

	public UserInfo(long userId, String userName, String pwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
