package com.learning.java.lesson3.objects;

public class HardcodedBusinessDataSource implements BusinessDataSource {

    @Override
    public String getBusinessData() {
        return "Hardcoded business data";
    }

}
