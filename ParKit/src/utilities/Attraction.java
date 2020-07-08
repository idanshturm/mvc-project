package utilities;

public class Attraction {
	
	private String id;
	private String parkId;
	private String name;
	private String description;
	private boolean isAvailable;
	private boolean scary;
	private boolean water;
	private boolean kids;
	private boolean heights;
	private boolean rollerCoaster;
	
	
	public Attraction(String id, String parkId, String name, String description, boolean isAvailable, boolean scary,
			boolean water, boolean kids, boolean heights, boolean rollerCoaster) {
		super();
		this.id = id;
		this.parkId = parkId;
		this.name = name;
		this.description = description;
		this.isAvailable = isAvailable;
		this.scary = scary;
		this.water = water;
		this.kids = kids;
		this.heights = heights;
		this.rollerCoaster = rollerCoaster;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParkId() {
		return parkId;
	}
	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDiscription(String discription) {
		this.description = discription;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean isScary() {
		return scary;
	}
	public void setScary(boolean scary) {
		this.scary = scary;
	}
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	public boolean isKids() {
		return kids;
	}
	public void setKids(boolean kids) {
		this.kids = kids;
	}
	public boolean isHeights() {
		return heights;
	}
	public void setHeights(boolean heights) {
		this.heights = heights;
	}
	public boolean isRollerCoaster() {
		return rollerCoaster;
	}
	public void setRollerCoaster(boolean rollerCoaster) {
		this.rollerCoaster = rollerCoaster;
	}
	
	

}
