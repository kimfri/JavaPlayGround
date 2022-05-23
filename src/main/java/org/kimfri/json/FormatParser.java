package org.kimfri.json;

import com.google.inject.Inject;
import org.kimfri.json.model.Meta;
import org.kimfri.json.model.Metadata;
import org.kimfri.json.model.MetadataParser;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class FormatParser {

    private MetadataParser metadataParser;

    @Inject
    public FormatParser(MetadataParser metadataParser) {
        this.metadataParser = metadataParser;
    }

    String getUuidFromMetadataFile(File file) throws IOException {
        return Optional.ofNullable(metadataParser.parseMetadataFile(file).getMeta())
                .map(Meta::getUuid)
                .orElse("No Uuid found");
    }

    Metadata getMetadata(File file) throws IOException {
        return metadataParser.parseMetadataFile(file);
    }
}
