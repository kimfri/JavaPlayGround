package org.kimfri.lombokstuff;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LombokThingiesTest {

    @Test
    void someThing1() {
        final Toy kalle = new Toy.ToyBuilder()
                .name("Kalle")
                .color("purple")
                .color("white")
                .build();
        System.err.println(kalle);
        val apa = "kim";
        if (apa instanceof String) System.err.println("its a string");
    }

    @Test
    void someFile() throws IOException {
        final Path path = Paths.get("target/kalle.txt");
        if(Files.exists(path)) {
            System.err.println(Files.size(path));
            Files.write(path, "WTF??".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } else {
            Files.write(path, "WTF??".getBytes(StandardCharsets.UTF_8));
        }

    }

}