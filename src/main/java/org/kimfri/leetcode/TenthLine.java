package org.kimfri.leetcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TenthLine {
    public void printTenthLineOfFile(Path path) throws IOException {

        System.err.println(Files.readAllLines(path).stream()
                .skip(9)
                .findFirst()
                .orElse("Not enough data"));
    }
}
