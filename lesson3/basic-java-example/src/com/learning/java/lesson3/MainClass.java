package com.learning.java.lesson3;

import com.learning.java.lesson3.objects.BusinessDataSource;
import com.learning.java.lesson3.objects.BusinessDataSourceFactory;
import com.learning.java.lesson3.objects.BusinessObject;

public class MainClass {

    public static void main(String[] args) {
        BusinessDataSource dataSource = BusinessDataSourceFactory.createDataSource(args);
        String businessData = dataSource.getBusinessData();
        BusinessObject businessObject = new BusinessObject(businessData);
        businessObject.doSomeBusinessStuff();
    }

}
