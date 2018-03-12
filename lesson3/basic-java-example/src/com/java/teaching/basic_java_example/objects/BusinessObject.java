package com.java.teaching.basic_java_example.objects;

public class BusinessObject {

    private final String businessData;

    public BusinessObject(String businessData) {
        this.businessData = businessData;
    }

    public void doSomeBusinessStuff() {
        System.out.println("Doing a business stuff with business data: " + businessData);
    }
}
