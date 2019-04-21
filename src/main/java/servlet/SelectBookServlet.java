package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mooc.admin.Book;

import service.LibServiceImpl;

/**
 * Servlet implementation class SelectBookServlet
 */
@WebServlet("/SelectBook")
public class SelectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String bookName = request.getParameter("bookName");
		String categoryName = request.getParameter("categoryName");
		LibServiceImpl lsi = new LibServiceImpl();
		List<Book> books = lsi.getBooksByCondition(id, bookName, categoryName);
		String json = JSON.toJSONString(books);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(json);
	}

}
