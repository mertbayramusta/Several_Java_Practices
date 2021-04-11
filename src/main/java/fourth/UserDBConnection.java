package fourth;
import java.util.*;  
import java.sql.*;  
public class UserDBConnection {
	//private static final long serialVersionUID = 1L;
	static final String jdbc_Driver = "org.postgresql.Driver";
	static final String db_url = "jdbc:postgresql://localhost:5432/postgres";
	
	static final String user = "postgres";
	static final String pass = "2241";
 
	 public static Connection getConnection() {
		 Connection con=null;  
	        try{  
	            Class.forName(jdbc_Driver);  
	            con=DriverManager.getConnection(db_url, user, pass);  
	        }catch(Exception e){System.out.println(e);} 
		 return con; 
	 }
	 
	    public static int save(User user){  
	        int status=0;  
	        try{  
	            Connection con=UserDBConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(
	            		"INSERT INTO usertable (username, email, birthday, sex, password, id) values (?,?,?,?,?,?)");  
	            ps.setString(1,user.getUsername());  
	            ps.setString(2,user.getEmail()); 
	            ps.setString(3,user.getBirthday()); 
	            ps.setString(4,user.getSex()); 
	            ps.setString(5,user.getPassword());  
	            ps.setInt(6,user.getId());  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(User user){  
	        int status=0;  
	        System.out.println(user.getUsername() + user.getEmail() + user.getBirthday() + user.getSex() + user.getPassword() + user.getId());
	        try{  
	            Connection con=UserDBConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "UPDATE usertable set username=?, email=?, birthday=?, sex=?, password=?, id=? where username=?");  
	            ps.setString(1,user.getUsername());  
	            ps.setString(2,user.getEmail()); 
	            ps.setString(3,user.getBirthday()); 
	            ps.setString(4,user.getSex()); 
	            ps.setString(5,user.getPassword());  
	            ps.setInt(6,user.getId());
	            ps.setString(7,user.getUsername());   
	            
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }
	    public static User getUserId(int id){  
	        User user=new User();  
	          
	        try{  
	            Connection con=UserDBConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT * FROM usertable where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	user.setUsername(rs.getString(1));  
	                user.setEmail(rs.getString(2));  
	                user.setBirthday(rs.getString(3));  
	                user.setSex(rs.getString(4));  
	                user.setPassword(rs.getString(5));
	                user.setId(rs.getInt(6));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return user;  
	    } 
	    public static User getUserUsername(String username){  
	        User user=new User();  
	          
	        try{  
	            Connection con=UserDBConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT * FROM usertable where username=?");  
	            ps.setString(1,username);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	user.setUsername(rs.getString(1));  
	                user.setEmail(rs.getString(2));  
	                user.setBirthday(rs.getString(3));  
	                user.setSex(rs.getString(4));  
	                user.setPassword(rs.getString(5));
	                user.setId(rs.getInt(6));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return user;  
	    }
	    public static int delete(String username){  
	        int status=0;  
	        try{
	            Connection con=UserDBConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("DELETE FROM usertable where username=?");  
	            ps.setString(1,username);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }
	    public static List<User> getAllUsers(){  
	        List<User> list=new ArrayList<>();  
	          
	        try{  
	            Connection con=UserDBConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT * FROM usertable");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                User user=new User();  
	                user.setUsername(rs.getString(1));  
	                user.setEmail(rs.getString(2));  
	                user.setBirthday(rs.getString(3));  
	                user.setSex(rs.getString(4));  
	                user.setPassword(rs.getString(5));
	                user.setId(rs.getInt(6));
	                list.add(user);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
