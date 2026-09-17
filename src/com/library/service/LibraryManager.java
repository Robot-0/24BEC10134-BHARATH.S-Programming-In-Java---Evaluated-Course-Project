package com.library.service;

import com.library.dao.BookDAO;
import com.library.dao.FileBookDAO;
import com.library.exception.BookNotFoundException;
import com.library.exception.UserLimitExceededException;
import com.library.model.Book;
import com.library.model.Student;
import com.library.model.User;

import java.util.List;

public class LibraryManager {
    private BookDAO bookDAO;

    public LibraryManager(){
        this.bookDAO = new FileBookDAO();
    }
    
    public void addBook(Book book){
        bookDAO.addBook(book);
    }

    public List<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }

    public Book searchBookById(String bookId) throws BookNotFoundException{
        Book book = bookDAO.getBookById(bookId);
        if(book==null){
            throw new BookNotFoundException("Book with ID'"+ bookId +"'was not found.");

        }
        return book;
    }

    public boolean issueBook(Student student, String bookId) throws BookNotFoundException, UserLimitExceededException{
        if(!student.canBorrowMore()){
            throw new UserLimitExceededException("Student" + student.getName()+ " has reached the maximum borrowing limit.");

        }
        Book book = searchBookById(bookId);
        if(!book.isAvailable()){
            return false;
        }
        book.setAvailable(false);
        bookDAO.updateBook(book);
        student.incrementBorrowedCount();
        return true;

    }
    
    public boolean returnBook(Student student, String bookId) throws BookNotFoundException{
        Book book = searchBookById(bookId);
        if(book.isAvailable()){
            return false;
        }
        book.setAvailable(true);
        bookDAO.updateBook(book);
        student.decrementBorrowedCount();
        return true;
        


    }
}
