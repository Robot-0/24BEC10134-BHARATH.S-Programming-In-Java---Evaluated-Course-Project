package com.library;
import com.library.exception.BookNotFoundException;
import com.library.exception.UserLimitExceededException;
import com.library.model.Book;
import com.library.model.Student;
import com.library.service.FineCalculator;
import com.library.service.LibraryManager;
import com.library.util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        manager.addBook(new Book("B101", "Dune", "Frank Herbert"));
        manager.addBook(new Book("B102", "Percy Jackson", "Rick Riordan"));
        manager.addBook(new Book("B103", "Design Patterns", "Erich Gamma"));

        Student activeStudent = new Student("S101", "Alex Smith");

        System.out.println("Welcome to Library Management System");

        boolean running = true;
        while(running){
            System.out.println("1. View Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return Book");
            System.out.println("4. Calculate Overdue Fine");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            String input = scanner.nextLine();
            switch(input.trim()){
                case "1":
                    List <Book> books = manager.getAllBooks();
                    for(Book b: books){
                        System.out.println(b);
                    }
                    break;
                case "2":
                    System.out.println("Enter Book ID to issue: ");
                    String issueId = scanner.nextLine();
                    if(!InputValidator.isValidId(issueId)){
                        System.out.println("Error: Invliad Book ID format");
                        break;
                    }
                    try{
                        boolean success = manager.issueBook(activeStudent, issueId);
                        if(success){
                            System.out.println("Sucess: Book issued to "+ activeStudent.getName());

                        }
                        else{
                            System.out.println("Error: Book is already issued.");

                        }
                    }
                        catch(BookNotFoundException|UserLimitExceededException e){
                            System.out.println("Error: " + e.getMessage());
                        }
                    
                    break;
                
                case "3":
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    if(!InputValidator.isValidId(returnId)){
                        System.out.println("Error: Invalid Book ID format.");
                        break;
                    }
                    try{
                        boolean success = manager.returnBook(activeStudent, returnId);
                        if(success){
                            System.out.println("Book returned succesfully");
                            
                        } else{
                            System.out.println("Book was not checked out");
                        }
                    } catch (BookNotFoundException e){
                        System.out.println("Error "+ e.getMessage());
                    }
                    break;
                
                case "4":
                    System.out.print("enter number of overdue days: ");
                    try{
                        int days = Integer.parseInt(scanner.nextLine());
                        double fine = FineCalculator.calculateFine(days);
                        System.out.printf("Total Overdue Fine: $%.2f%n", fine);

                    } catch(NumberFormatException e){
                        System.out.println("Error: Please enter valid number of days.");
                    }
                    break;
                
                case "5":
                    running = false;
                    System.out.println("Exiting system. Thank you!");
                    break;
                
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5");
                    
            }
        }

        scanner.close();
                

            

        }
    }
    

