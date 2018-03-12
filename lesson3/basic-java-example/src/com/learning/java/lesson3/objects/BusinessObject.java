package com.learning.java.lesson3.objects;

public class BusinessObject {

    private final String businessData;

    public BusinessObject(String businessData) {
        this.businessData = businessData;
    }

    public void doSomeBusinessStuff() {
        System.out.println("Doing a business stuff with business data: " + businessData);
    }
}
