package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mooc.admin.User;

import dao.LibDaoImpl;
import service.LibServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //登录。创建新用户
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String tel = request.getParameter("phone");
		String email = request.getParameter("email");
		User user = new User(name, password, tel, email);
		
		LibServiceImpl lsi = new LibServiceImpl();
		//名称未注册过
		if( lsi.isUserExist(name)==-1 ) {
			lsi.regist(user);
			HttpSession sesison = request.getSession();
			sesison.removeAttribute("loginUser");
		}
		response.sendRedirect(request.getContextPath()+"/pages/server/index.jsp");
		String data = "";
		response.getOutputStream().write(data.getBytes());
	}

}
