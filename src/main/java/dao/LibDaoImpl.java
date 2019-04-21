package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mooc.admin.Book;
import com.mooc.admin.User;

public class LibDaoImpl {
	private static final List<User> userDb = new ArrayList<>();
	private static final List<Map<String, Object>> categories = new ArrayList<>();
	private static final List<Book> books = new ArrayList<>();
	
	public void regist(User user) {
		//若userDb里没有该用户，就添加
		if( isUserExist(user.getUserName())==-1 ) {
			userDb.add(user);			
		}
	}
	//判断用户在表里是否存在，存在返回索引值，不存在返回-1
	public int isUserExist(String username) {
		for( int i=0; i<userDb.size(); i++ ) {
			if( userDb.get(i).getUserName().equals(username) ) {
				return i;
			}
		}
		return -1;
	}
	
	//登录，先判断该用户名是否存在，存在则继续判断密码是否正确。登录成功返回true
	public boolean login(String username, String password) {
		int index = isUserExist(username);
		if( index!=-1 ) {
			if( userDb.get(index).getUserPwd().equals(password) ) {
				return true;
			}
		}
		return false;
	}
	
	//添加图书分类,每个map存一个分类，categories是一个map组成的集合
	public void addBookCategory(String id, String categoryName, String description) {
		Map<String, Object> category = new HashMap<>();
		category.put("id", id);
		category.put("categoryName", categoryName);
		category.put("description", description);
		categories.add(category);
	}
	
	//获取所有的分类信息
	public List<Map<String, Object>> getAllBookCategory() {
		return categories;
	}
	
	//添加图书
	public void addBook(Book book) {
		books.add(book);
	}
	
	//查询所有图书信息
	public List<Book> getAllBooks() {
		return books;
	}
	
	//根据条件来查询书籍信息,可以少条件。返回的是符合条件的书的集合
	public List<Book> getBooksByCondition(String bookID, String bookName, String categoryName) {
		List<Book> bookList = new ArrayList<>();
		for( Book temp : books ) {
			String id = temp.getBookID();
			String bn = temp.getBookName();
			String cn = temp.getCategoryName();
			if( bookID.isEmpty() && bookName.isEmpty() && categoryName.isEmpty() ) {
				continue;
			}
			if( !bookID.isEmpty() ) {
				if( !id.equals(bookID) ) {
					continue;
				}
			}
			if( !bookName.isEmpty() ) {
				if( !bn.equals(bookName) ) {
					continue;
				}
			}
			if( !categoryName.isEmpty() ) {
				if( !cn.equals(categoryName) ) {
					continue;
				}
			}
			bookList.add(temp);
		}
		return bookList;
	}
}
