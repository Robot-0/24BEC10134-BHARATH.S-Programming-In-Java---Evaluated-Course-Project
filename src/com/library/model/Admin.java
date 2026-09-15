package com.library.model;

public class Admin extends User {
    private String department;
    public Admin(String userId, String name, String department){
        super(userId, name, "Admin");
        this.department = department;
    }

    public String getDepartment() {return department;}
    
}
