package org.kimfri.protobuff.using;

import com.google.protobuf.InvalidProtocolBufferException;
import org.kimfri.protobuff.Captain;
import org.kimfri.protobuff.SpaceShip;
import org.kimfri.protobuff.SpaceStation;

import java.util.Optional;

public class SpaceStationMain {
    public static void main(String[] args) {
        SpaceStationMain spaceStationMain = new SpaceStationMain();
        spaceStationMain.doit();
    }

    private void doit() {
        Captain captain = Captain.newBuilder().setName("Cpt. Kirk").build();
        SpaceShip spaceShip = SpaceShip.newBuilder().setName("Enterprise").build();
        SpaceStation spaceStation = SpaceStation.newBuilder()
                .setName("X11")
                .setCaptain(captain)
                .setSpaceShip(spaceShip)
                .build();

        Serializer serializer = new Serializer();
        String filename = "target/kimfri-spacestation.pbuf";
        serializer.serializeProtobuff(spaceStation, filename);

        Optional<SpaceStation> spaceStationOptional = serializer.unSerializeProtobuf(filename);
        spaceStationOptional
                .ifPresent(System.err::println);

        spaceStationOptional
                .ifPresent(it -> {
                    try {
                        String jsonStringFromProtoBuf = serializer.getJsonStringFromProtoBuf(it);
                        System.err.println("*****************  Json  *****************");
                        System.err.println(jsonStringFromProtoBuf);
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                    }
                });
    }
}
