package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mooc.admin.Book;

import service.LibServiceImpl;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String bookName = request.getParameter("bookName");
		String category = request.getParameter("categoryName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		//按字段生成书籍
		Book book = new Book(id, bookName, category, price, description);
		LibServiceImpl lsi = new LibServiceImpl();
		//添加书籍
		lsi.addBook(book);
		response.sendRedirect(request.getContextPath()+"/pages/server/showBooks.jsp");
	}

}
