package com.sterlite.bsnl.dao;

import java.util.List;

import com.sterlite.bsnl.entity.Book;

public interface IBookStoreDAO {
	
	List<Book> getBooks();
	Book getBook(int bookId);
	Book createBook(Book book);
	Book updateBook(int bookId,Book book);
	boolean deleteBook(int bookId);

}
