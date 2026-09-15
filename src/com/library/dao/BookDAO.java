package com.library.dao;

import com.library.model.Book;
import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    Book getBookById(String bookId);
    List<Book> getAllBooks();
    void updateBook(Book book);
    boolean deleteBook(String bookId);
    
}
