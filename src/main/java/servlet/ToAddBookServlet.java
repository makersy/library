package servlet;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.LibServiceImpl;

/**
 * Servlet implementation class ToAddBookServlet
 */
@WebServlet("/ToAddBookServlet")
public class ToAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibServiceImpl lsi = new LibServiceImpl();
		List<Map<String, Object>> categories = lsi.getAllBookCategory();
		String json = JSON.toJSONString(categories);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(json);
	}

}
