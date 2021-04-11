package fourth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update User</h1>");  
        
        String username = request.getParameter("username");
        		
        User user=UserDBConnection.getUserUsername(username); 
          
        out.print("<form action='UpdateServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='username' value='"+user.getUsername()+"'/></td></tr>"); 
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+user.getEmail()+"'/></td></tr>"); 
        out.print("<tr><td>Birthday:</td><td><input type='text' name='birthday' value='"+user.getBirthday()+"'/></td></tr>"); 
        out.print("<tr><td>Sex:</td><td><input type='text' name='sex' value='"+user.getSex()+"'/></td></tr>"); 
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+user.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Id:</td><td><input type='text' name='id' value='"+user.getId()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Update & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		
	}

}
