package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import utilities.Attraction;
import utilities.Order;
import utilities.Park;
import utilities.ParkAdmin;

public class Database {
	
	private static Database db = null;
	
	private Database() {}
	
	public static Database getInstance() {
		if (db == null)
			db = new Database();
		return db;
	}
	
	private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:src/Database/ParKitDatabase.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
	
	public boolean isManager(String id, String password) {
		
		String sql = "SELECT * FROM admin where id = ? and password = ?";  

        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
	}
	
	public boolean isAdminExist(String id) {
		
		String sql = "SELECT * FROM park_admin where id = ?";  
        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
	}
	
public boolean isParkExist(String id) {
		
		String sql = "SELECT * FROM park where id = ?";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
	}
	
	public boolean isParkAdmin(String parkId, String UserId, String password) {
		
		String sql = "SELECT * FROM park where id = ? and admin_id = ? and password = ?";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, parkId);
            pstmt.setString(2, UserId);
            pstmt.setString(3, password);
            ResultSet rs = pstmt.executeQuery();  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
	}
	
	public ResultSet getParkList () {
		
		String sql = "SELECT id, name FROM park";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();  

            return rs;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}
	
	public ResultSet getAttractionsList (String parkId) {
		
		String sql = "SELECT id, name, description, is_available FROM attraction where park_id = ?";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, parkId);
            ResultSet rs = pstmt.executeQuery();  

            return rs;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}
	
	public ResultSet getAttractionsListFilterd (String parkId, HashMap<String, Boolean> tags) {
		
		String sql = "";  
		String s = "";
		
		if(tags.isEmpty())
			return getAttractionsList(parkId);
		else {
			sql = "SELECT id, name, description, is_available FROM attraction where ";
		}
		
		for(Map.Entry<String, Boolean> entry : tags.entrySet()) {
			s += entry.getKey() + "=" + entry.getValue() + " and ";
		}
        
		sql += s + "park_id = ?;";
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, parkId);
            ResultSet rs = pstmt.executeQuery();  

            return rs;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}
	
	public void addParkAdmin(ParkAdmin admin) {  
        String sql = "INSERT INTO park_admin(id, password) VALUES(?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, admin.getId());  
            pstmt.setString(2, admin.getPassword());  
            pstmt.executeUpdate();  
        	pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
	
	public void addPark(Park park) {  
        String sql = "INSERT INTO park(id, name, admin_id, password) VALUES(?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, park.getId());  
            pstmt.setString(2, park.getName());
            pstmt.setString(3, park.getAdmin_id());
            pstmt.setString(4, park.getPass());
            pstmt.executeUpdate();  
        	pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 
	
	public String getParkAdminPass(String id) {
		
		String sql = "SELECT password FROM park_admin where id = ?";  

        
       try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            String pass = rs.getString("password");
            rs.close();
            conn.close();
            return pass;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}
	
	public String getLastOrderId() {
		
		String sql = "SELECT MAX(id) as id FROM orders";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
            	return "1";
            }
            
            String idFromDb = rs.getString("id");
            int idNum = Integer.parseInt(idFromDb);
            idNum += 1;
            String idToReturn = String.valueOf(idNum);
            rs.close();
            conn.close();
            return idToReturn;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}
	
	public void addOrder(Order order) {  
        String sql = "INSERT INTO orders(id, park_id, client_name, client_number, regular_tic_amount, kid_tic_amount, soldier_tic_amount, senior_tic_amount, total_price) VALUES(?,?,?,?,?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, order.getOrderId());  
            pstmt.setString(2, order.getParkId());
            pstmt.setString(3, order.getClientName());  
            pstmt.setString(4, order.getClientPhoneNumber());
            pstmt.setInt(5, order.getRegularTicketAmount());
            pstmt.setInt(6, order.getKidTicketAmount());
            pstmt.setInt(7, order.getSoldierTicketAmount());
            pstmt.setInt(8, order.getSeniorTicketAmount());
            pstmt.setInt(9, order.getTotalPrice());

            pstmt.executeUpdate();  
        	pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 
	
	
	public ResultSet getOrdersList (String parkId) {
		
		String sql = "SELECT * FROM orders where park_id = ?";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, parkId);
            ResultSet rs = pstmt.executeQuery();  

            return rs;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}
	
	public boolean isAttractionExist(String id, String parkId) {
		
		String sql = "SELECT * FROM attraction where id = ? and park_id = ?";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, parkId);
            ResultSet rs = pstmt.executeQuery();  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
	}
	
	
	public void addAttraction(Attraction attraction) {  
        String sql = "INSERT INTO attraction(id, park_id, name, description, is_available, scary, water, kids, heights, roller_coaster) VALUES(?,?,?,?,?,?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, attraction.getId());  
            pstmt.setString(2, attraction.getParkId());
            pstmt.setString(3, attraction.getName());
            pstmt.setString(4, attraction.getDescription());
            pstmt.setBoolean(5, attraction.isAvailable());
            pstmt.setBoolean(6, attraction.isScary());
            pstmt.setBoolean(7, attraction.isWater());
            pstmt.setBoolean(8, attraction.isKids());
            pstmt.setBoolean(9, attraction.isHeights());
            pstmt.setBoolean(10, attraction.isRollerCoaster());
            pstmt.executeUpdate();  
        	pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 
	
	public void deleteAttraction(String id, String parkId) {
        String sql = "DELETE FROM attraction WHERE id = ? and park_id = ?";
 
        try  {
        	
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
 
            // set the corresponding @param
            pstmt.setString(1, id);
            pstmt.setString(2, parkId);
            // execute the delete statement
            pstmt.executeUpdate();
            pstmt.close();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
	public boolean testIsParkAdmin(String id, String password) {
		
		String sql = "SELECT * FROM park_admin where id = ? and password = ?";  

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
	}

	public void testDeleteParkAdmin(String id) {
	    String sql = "DELETE FROM park_admin WHERE id = ?";
	
	    try  {
	    	
	    	Connection conn = this.connect();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	
	        // set the corresponding @param
	        pstmt.setString(1, id);
	        // execute the delete statement
	        pstmt.executeUpdate();
	        pstmt.close();
	
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

	
    public void testUpdateAttractionScaryField(String id, String parkId, boolean isScary) {
    	
        String sql = "UPDATE attraction SET scary = ? WHERE id = ? and park_id = ?";
 
        try 
        {
        	Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            // set the corresponding @param
            pstmt.setBoolean(1, isScary);
            pstmt.setString(2, id);
            pstmt.setString(3, parkId);
            
            // update
            pstmt.executeUpdate();
            pstmt.closeOnCompletion();
            conn.close();
//            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    

    public Attraction testGetAttraction(String id, String parkId) {
		
		String sql = "SELECT * FROM attraction where id = ? and park_id = ?";  

        
        try {  
        	System.out.println("1");
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, parkId);
            ResultSet rs = pstmt.executeQuery();  
            
            System.out.println("2");

            String idFromDb = rs.getString(1);
            System.out.println("3");
            String parkIdFromDb = rs.getString(2);
            String name= rs.getString(3);
            String description = rs.getString(4);;
            boolean isAvailable = rs.getBoolean(5);
            boolean scary = rs.getBoolean(6);
            boolean water = rs.getBoolean(7);
            boolean kids = rs.getBoolean(8);
            boolean heights = rs.getBoolean(9);
            boolean rollerCoaster = rs.getBoolean(10);

            
            Attraction attraction = new Attraction(idFromDb, parkIdFromDb, name, description, isAvailable, scary, water, kids, heights, rollerCoaster);
            
            return attraction;

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return null;
	}

	

}
