package com.learning.java.lesson3.objects;

public class BusinessDataSourceFactory {

    private static final ArgumentsParser argumentsParser = new ArgumentsParser();

    public static BusinessDataSource createDataSource(String[] args) {
        ProgramProperties properties = argumentsParser.parse(args);

        if (properties.isResourcesDataSource()) {
            String path = properties.getDataSourceResourcePath();
            return new ResourcesBusinessDataSource(path);
        } else if (properties.isArgumentsDataSource()) {
            String[] arguments = properties.getDataSourceArguments();
            return new CommandLineArgumentsBusinessDataSource(arguments);
        } else {
            return new HardcodedBusinessDataSource();
        }
    }
}
