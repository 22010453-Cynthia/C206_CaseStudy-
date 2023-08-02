
public class Events {
	private String eName;
	private String eTime;
	private String eDate;
	private String eDescription;
	private String eVenue;
	
	
	public Events(String eName, String eTime, String eDate, String eVenue,String eDescription) {
		
		this.eName = eName;
		this.eTime = eTime;
		this.eDate = eDate;
		this.eVenue = eVenue;
		this.eDescription = eDescription;
		
	
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String geteDescription() {
		return eDescription;
	}

	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}

	public String geteVenue() {
		return eVenue;
	}

	public void seteVenue(String eVenue) {
		this.eVenue = eVenue;
	}


	
	
	

}
