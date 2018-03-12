package com.learning.java.lesson3.objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourcesBusinessDataSource implements BusinessDataSource {

    private final String data;

    public ResourcesBusinessDataSource(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            data = lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBusinessData() {
        return data;
    }

}
