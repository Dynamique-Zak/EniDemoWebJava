package fr.eni.demo.bll;

public class EniDemoResponse {

	public int responseCode;
	public String responseMessage;
	
	public EniDemoResponse(int reponseCode, String responseMessage) {
		super();
		this.responseCode = reponseCode;
		this.responseMessage = responseMessage;
	}
	
	public boolean isValid() {
		return (responseCode >= 200 && responseCode < 300);
	}
}
