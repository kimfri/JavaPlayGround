package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TenthLineTest {

    @Test
    void printTenthLine() throws IOException {
        final String filename = "/file.txt";
        final Path path = Paths.get("src","test","resources", filename);
        TenthLine tenthLine = new TenthLine();
        tenthLine.printTenthLineOfFile(path);
    }
}