package org.kimfri.csv;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class MyCsvParserTest {
    @Test
    void kalle() throws IOException {
        final Path path2 = Paths.get("src", "test", "resources", "csv", "testdata.csv");
        MyCsvParser myCsvParser = new MyCsvParser();
        final List<Person> personList = myCsvParser.parse(path2);
        personList.forEach(it -> {
            System.err.println(it.getFirstName() + " " + it.getLastName() + " " + it.getAge());
        });
    }
}