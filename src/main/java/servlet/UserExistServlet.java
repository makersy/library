package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LibServiceImpl;

/**
 * Servlet implementation class UserExistServlet
 */
@WebServlet("/UserExist")
public class UserExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 判断是否被注册过
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		System.out.println(name);
		LibServiceImpl lsi = new LibServiceImpl();
		response.setCharacterEncoding("utf-8");
		if( name!=null && lsi.isUserExist(name)<0 ) {
			//未注册过
			response.getWriter().write("0");
		}else if( name!=null && lsi.isUserExist(name)>=0 ){
			//注册过
			response.getWriter().write("1");
		}
	}

}
