package dao;

public class DBConfigure {

	private String url;
	private String user;
	private String password;
	
	public DBConfigure(){
		this.url = "jdbc:mysql://localhost:3306/teste1";
		this.user = "siscot";
		this.password = "12345";
	}

	public String getUrl() {
		return url;
	}


	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
