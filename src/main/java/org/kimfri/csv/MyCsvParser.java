package org.kimfri.csv;

import org.apache.commons.csv.CSVFormat;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class MyCsvParser {
    private final CSVFormat csvFormat = CSVFormat
            .Builder
            .create()
            .setHeader(Header.class)
            .setSkipHeaderRecord(true)
            .setIgnoreEmptyLines(true)
            .setAllowMissingColumnNames(true)
            .build();

    void parse(Path path) throws IOException {
        final FileReader fileReader = new FileReader(path.toFile());

        csvFormat.parse(fileReader)
                .getRecords()
                .forEach(it -> {
                    System.err.println(it.get(Header.FIRST_NAME));
                    System.err.println(it.get(Header.LAST_NAME));

                    Optional.ofNullable(it.isSet(Header.AGE.name()) ? it.get(Header.AGE) : null)
                            .ifPresent(System.err::println);

                });
    }
}
