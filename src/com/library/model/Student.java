package com.library.model;

public class Student extends User {
    private int booksBorrowedCount;
    private static final int MAX_BORROW_LIMIT = 3;
    
    public Student(String userId, String name){
        super(userId, name, "Student");
        this.booksBorrowedCount=0;

    }
    public int getBooksBorrowedCount(){return booksBorrowedCount; }
    public static int getMaxBorrowLimit() {return MAX_BORROW_LIMIT;}

    public boolean canBorrowMore(){
        return booksBorrowedCount< MAX_BORROW_LIMIT;

    }
    public void incrementBorrowedCount() {this.booksBorrowedCount++;}
    public void decrementBorrowedCount(){
        if(this.booksBorrowedCount>0) this.booksBorrowedCount--;
    }
    
}
