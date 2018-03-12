package com.java.teaching.basic_java_example.objects;

public class HardcodedBusinessDataSource implements BusinessDataSource {

    @Override
    public String getBusinessData() {
        return "Hardcoded business data";
    }

}
