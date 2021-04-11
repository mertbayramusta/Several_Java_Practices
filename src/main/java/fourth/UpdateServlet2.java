package fourth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  

        String username=request.getParameter("username");  
        String email=request.getParameter("email");  
        String birthday=request.getParameter("birthday");  
        String sex=request.getParameter("sex");  
        String password=request.getParameter("password");  
        String sid=request.getParameter("id");  
        int id = Integer.parseInt(sid);
          
        User user=new User();  
          
        user.setUsername(username); 
        user.setEmail(email);
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setPassword(password);
        user.setId(id);   
          
        int status=UserDBConnection.update(user);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
	}

}
