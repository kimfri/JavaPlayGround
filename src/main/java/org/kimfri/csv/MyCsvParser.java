package org.kimfri.csv;

import org.apache.commons.csv.CSVFormat;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class MyCsvParser {
    void parse(Path path) throws IOException {
        final FileReader fileReader = new FileReader(path.toFile());
        final CSVFormat csvFormat = CSVFormat
                .Builder
                .create()
                .setHeader(Header.class)
                .setSkipHeaderRecord(true)
                .setIgnoreEmptyLines(true)
                .setAllowMissingColumnNames(true)
                .build();

        csvFormat.parse(fileReader)
                .getRecords()
                .forEach(it -> {
                    System.err.println(it.get(Header.FIRST_NAME));
                    System.err.println(it.get(Header.LAST_NAME));
                    if (it.isSet(Header.AGE.name())) {
                        System.err.println(it.get(Header.AGE));
                    }
                });
    }
}
