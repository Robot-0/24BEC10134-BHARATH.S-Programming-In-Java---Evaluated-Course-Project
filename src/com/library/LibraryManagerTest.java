package com.library;

import com.library.exception.BookNotFoundException;
import com.library.exception.UserLimitExceededException;
import com.library.model.Book;
import com.library.model.Student;
import com.library.service.LibraryManager;



public class LibraryManagerTest {

    public static void main(String[]args){
        System.out.println("Running Library Manager Tests");
        LibraryManager manager = new LibraryManager();
        Book testbook = new Book("T100", "Test Driven Java", "Author X");
        Student testStudent = new Student("S999", "Tester");
        manager.addBook(testbook);

        try{
            Book found = manager.searchBookById("T100");
            assert found != null;
            System.out.println("Test 1 Passed: Book Search Succesfull");
        } catch(BookNotFoundException e){
            System.out.println("Test 1 failed: "+ e.getMessage());
        }

        try{
            boolean issued = manager.issueBook(testStudent, "T100");
            if (issued && !testbook.isAvailable()){
                System.out.println("Test 2 passed: Issue Book Logic");

            } else{
                System.out.println("Test 2 failed");
            }

        } catch(Exception e){
            System.out.println("Test 2 Exception: " + e.getMessage());
        }
    }
    
}
