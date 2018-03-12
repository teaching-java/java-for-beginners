package com.learning.java.lesson3.objects;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CommandLineArgumentsBusinessDataSource implements BusinessDataSource {

    private final String data;

    public CommandLineArgumentsBusinessDataSource(String[] data) {
        this.data = Arrays.stream(data).collect(Collectors.joining("\n"));
    }

    @Override
    public String getBusinessData() {
        return data;
    }

}
