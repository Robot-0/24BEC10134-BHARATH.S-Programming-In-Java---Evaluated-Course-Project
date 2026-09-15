package com.library.model;

public class Book{
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String bookId, String title,  String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        
    }
    public String getBookId() {return bookId;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public boolean isAvailable() {return isAvailable;}
    
    public void setAvailable(boolean available) {isAvailable = available;}
    
    @Override
    public String toString(){
        return String.format("[%s] %s by %s | Status: %s", bookId, title, author, (isAvailable ? "Available" : "Issued"));
    }
    
            
}