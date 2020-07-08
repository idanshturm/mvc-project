package utilities;

public class Park {
	
	private String id;
	private String name;
	private String admin_id;
	private String pass;
	
	
	public Park(String id, String name, String admin_id, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.admin_id = admin_id;
		this.pass = pass;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
