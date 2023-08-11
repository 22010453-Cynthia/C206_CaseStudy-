
public class user {
	private String uName;
	private String ugmail;
	private String upassword;
	private String ubio;
	
	public user(String uName, String ugmail, String upassword, String ubio) {
		super();
		this.uName = uName;
		this.ugmail = ugmail;
		this.upassword = upassword;
		this.ubio = ubio;

	}
	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}



	public String getUbio() {
		return ubio;
	}



	public void setUbio(String ubio) {
		this.ubio = ubio;
	}



	public String getUgmail() {
		return ugmail;
	}



	public void setUgmail(String ugmail) {
		this.ugmail = ugmail;
	}



	public String getUpassword() {
		return upassword;
	}



	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
}
//