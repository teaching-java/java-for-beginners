package com.java.teaching.basic_java_example;

import com.java.teaching.basic_java_example.objects.BusinessDataSource;
import com.java.teaching.basic_java_example.objects.BusinessDataSourceFactory;
import com.java.teaching.basic_java_example.objects.BusinessObject;

public class MainClass {

    public static void main(String[] args) {
        BusinessDataSource dataSource = BusinessDataSourceFactory.createDataSource(args);
        String businessData = dataSource.getBusinessData();
        BusinessObject businessObject = new BusinessObject(businessData);
        businessObject.doSomeBusinessStuff();
    }

}
