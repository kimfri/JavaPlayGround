package org.kimfri.csv;

import org.apache.commons.csv.CSVFormat;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyCsvParser {
    private final CSVFormat csvFormat = CSVFormat
            .Builder
            .create()
            .setHeader(Header.class)
            .setSkipHeaderRecord(true)
            .setIgnoreEmptyLines(true)
            .setAllowMissingColumnNames(true)
            .build();

    List<Person> parse(Path path) throws IOException {
        final FileReader fileReader = new FileReader(path.toFile());

        return csvFormat.parse(fileReader)
                .getRecords()
                .stream().map(it -> new Person(it.get(Header.FIRST_NAME),
                         it.get(Header.LAST_NAME),
                         Optional.ofNullable(it.isSet(Header.AGE.name()) ? it.get(Header.AGE) : null)
                 ))
                .collect(Collectors.toList());
    }
}
