package service;

import java.util.List;
import java.util.Map;

import com.mooc.admin.Book;
import com.mooc.admin.User;

import dao.LibDaoImpl;

public class LibServiceImpl {
	LibDaoImpl ldi = new LibDaoImpl();
	
	public void regist(User user) {
		//若userDb里没有该用户，就添加
		if( ldi.isUserExist(user.getUserName())==-1 ) {
			ldi.regist(user);			
		}
	}
	
	public int isUserExist(String username) {
		return ldi.isUserExist(username);
	}
	
	public boolean login(String username, String password) {
		return ldi.login(username, password);
	}
	
	public void addBookCategory(String id, String categoryName, String description) {
		ldi.addBookCategory(id, categoryName, description);
	}
	
	public List<Map<String, Object>> getAllBookCategory() {
		return ldi.getAllBookCategory();
	}
	
	public void addBook(Book book) {
		ldi.addBook(book);
	}
	
	public List<Book> getAllBooks() {
		return ldi.getAllBooks();
	}
	
	public List<Book> getBooksByCondition(String bookID, String bookName, String categoryName) {
		return ldi.getBooksByCondition(bookID, bookName, categoryName);
	}
}
