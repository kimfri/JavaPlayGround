package org.kimfri.csv;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class MyCsvParserTest {
    @Test
    void kalle() throws IOException {
        final Path path2 = Paths.get("src", "test", "resources", "csv", "testdata.csv");
        MyCsvParser myCsvParser = new MyCsvParser();
        myCsvParser.parse(path2);
    }
}