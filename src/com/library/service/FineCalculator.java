package com.library.service;

public class FineCalculator {
    private static final double DAILY_FINE_RATE = 2.0;

    public static double calculateFine(int daysOverdue){
        if(daysOverdue<=0){
            return 0.0;
        }
        return daysOverdue * DAILY_FINE_RATE;
    }
    
}
