package utility;

public class Delete_file {
	String message;
	String sha;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	@Override
	public String toString() {
		return "{\"message\":\"" + message + "\", \"sha\":\"" + sha + "\"}";
	}
  
}
