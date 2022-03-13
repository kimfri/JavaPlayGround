package org.kimfri.protobuff.using;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.kimfri.protobuff.SpaceStation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class Serializer {
    void serializeProtobuff(SpaceStation spaceStation, String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            spaceStation.writeTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Optional<SpaceStation> unSerializeProtobuf(String filename) {
        SpaceStation spaceStation = null;
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            spaceStation = SpaceStation.parseFrom(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(spaceStation);
    }

    String getJsonStringFromProtoBuf(SpaceStation spaceStation) throws InvalidProtocolBufferException {
        JsonFormat.Printer printer = JsonFormat.printer()
                .includingDefaultValueFields()
                .preservingProtoFieldNames();
        return printer.print(spaceStation);
    }
}
