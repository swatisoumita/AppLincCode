package application.linc.user;

public class LoginRequest {
	
	String usrName;
	String usrPass;
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrPass() {
		return usrPass;
	}
	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}
	@Override
	public String toString() {
		return "LoginRequest [usrName=" + usrName + ", usrPass=" + usrPass + "]";
	}
	
	
	
	

}
