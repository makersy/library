package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LibServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession(true);
		LibServiceImpl lsi = new LibServiceImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setAttribute("username", username);
		if( username=="" ) {
			response.sendRedirect(request.getContextPath()+"/pages/server/index.jsp");
			return;
		}
		if( lsi.login(username, password) ) {
			//session.setAttribute("loginUser", username);
			//System.out.println(username+" : "+session.getId());
			response.sendRedirect(request.getContextPath()+"/pages/admin/login.jsp?username="+username);			
		}else {
			//若存在此用户但密码错误，返回flag=2，若不存在此用户返回flag=3
			if( lsi.isUserExist(username)!=-1 ) {
				response.sendRedirect(request.getContextPath()+"/pages/server/index.jsp?flag=2");				
			}else {
				response.sendRedirect(request.getContextPath()+"/pages/server/index.jsp?flag=3");
			}
		}
	}

}
