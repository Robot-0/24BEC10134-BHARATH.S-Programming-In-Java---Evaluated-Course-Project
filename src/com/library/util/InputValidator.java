package com.library.util;

public class InputValidator {
    public static boolean isValidString(String input){
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidId(String id){
        return isValidString(id)&& id.matches("^[a-zA-Z0-9-]+$");
    }
}
