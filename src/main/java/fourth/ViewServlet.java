package fourth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;  


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='add.jsp'>Add New User</a>");  
        out.println("<h1>User List</h1>");  
          
        List<User> list=UserDBConnection.getAllUsers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Username</th><th>Email</th><th>Birthday</th><th>Sex</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");  
        for(User user:list){  
         out.print("<tr><td>"+user.getId()+"</td><td>"+user.getUsername()+"</td><td>"+user.getEmail()+"</td><td>"+user.getBirthday()+"</td><td>"+user.getSex()+"</td><td>"+user.getPassword()+"</td><td><a href='UpdateServlet?username="+user.getUsername()+"'>Update</a></td><td><a href='DeleteServlet?username="+user.getUsername()+"'>Delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
