package com.maximus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private FileReader() {
        throw new IllegalStateException("Utility class");
    }

    public static String readTextFromFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public static List<String> readWordsFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}