package com.learning.java.lesson3.objects;

import java.util.Arrays;

public class ArgumentsParser {

    public ProgramProperties parse(String[] args) {
        if (args.length == 0) {
            return new ProgramProperties();
        }
        if (isPathParameter(args[0])) {
            return resourcesParameters(args);
        }
        if (isArgumentParameters(args[0])) {
            return argumentsParameters(args);
        }
        throw new IllegalArgumentException("Can't detect parameters");
    }

    private boolean isPathParameter(String arg) {
        return "source_path".equalsIgnoreCase(arg) || "sp".equalsIgnoreCase(arg);
    }

    private ProgramProperties resourcesParameters(String[] args) {
        if (args.length != 2) {
            if (args.length < 2) {
                throw new IllegalArgumentException("Source path isn't specified!");
            }
            throw new IllegalArgumentException("Incorrect arguments length! Two arguments are expected");
        }
        ProgramProperties programProperties = new ProgramProperties();
        programProperties.setDataSourceResourcePath(args[1]);
        return programProperties;
    }

    private boolean isArgumentParameters(String arg) {
        return "source".equalsIgnoreCase(arg) || "s".equalsIgnoreCase(arg);
    }

    private ProgramProperties argumentsParameters(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Source arguments aren't specified!");
        }
        String[] arguments = Arrays.copyOfRange(args, 1, args.length - 1);
        ProgramProperties programProperties = new ProgramProperties();
        programProperties.setDataSourceArguments(arguments);
        return programProperties;
    }

}
