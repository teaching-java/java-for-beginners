package com.learning.java.lesson3.objects;

public class ProgramProperties {

    private String dataSourceResourcePath;
    private String[] dataSourceArguments;

    public ProgramProperties() {
    }

    public String getDataSourceResourcePath() {
        return dataSourceResourcePath;
    }

    public void setDataSourceResourcePath(String dataSourceResourcePath) {
        this.dataSourceResourcePath = dataSourceResourcePath;
    }

    public boolean isResourcesDataSource() {
        return dataSourceResourcePath != null;
    }

    public String[] getDataSourceArguments() {
        return dataSourceArguments;
    }

    public void setDataSourceArguments(String[] dataSourceArguments) {
        this.dataSourceArguments = dataSourceArguments;
    }

    public boolean isArgumentsDataSource() {
        return dataSourceArguments != null;
    }

}
