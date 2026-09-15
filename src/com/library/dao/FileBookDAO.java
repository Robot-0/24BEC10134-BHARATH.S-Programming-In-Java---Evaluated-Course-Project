package com.library.dao;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class FileBookDAO implements BookDAO {
    private List<Book> bookStorage = new ArrayList<>();

    @Override 
    public void addBook(Book book){
        bookStorage.add(book);
    }

    @Override 
    public Book getBookById(String bookId){
        return bookStorage.stream()
                .filter(b -> b.getBookId().equalsIgnoreCase(bookId))
                .findFirst()
                .orElse(null);
    }

    @Override 
    public List<Book> getAllBooks(){
        return bookStorage;

    }
    @Override 
    public void updateBook(Book book){
        Book existing = getBookById(book.getBookId());
        if(existing!=null){
            existing.setAvailable(book.isAvailable());
        }
    }

    @Override 
    public boolean deleteBook(String bookId){
        return bookStorage.removeIf(b -> b.getBookId().equalsIgnoreCase(bookId));
        
    }
    
}
