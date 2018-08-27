package com.sterlite.bsnl.services;

import java.util.List;

import com.sterlite.bsnl.entity.Book;

public interface IBookStoreService {
	
	List<Book> getBooks();
	Book createBook(Book book);
	Book updateBook(int bookId, Book book);
	Book getBook(int bookId);
	boolean deleteBook(int bookId);

}
