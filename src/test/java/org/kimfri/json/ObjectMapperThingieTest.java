package org.kimfri.json;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ObjectMapperThingieTest {

    @Test
    void readFromFileToObject() throws IOException {
        File jsonFile = new File("target/Emp.json");
        final JsonNode jsonNode = ObjectMapperThingie.pareFile(jsonFile);
        final Employee employee = ObjectMapperThingie.fromJson(jsonNode, Employee.class);
        Optional.ofNullable(employee).ifPresent(it -> System.err.println("name: " + it.getName()));
    }

    @Test
    void readListFromFileToObject() throws IOException {
//        File jsonFile = new File("target/EmpList.json");
//        final JsonNode jsonNode = ObjectMapperThingie.pareFile(jsonFile);
//        final ArrayList arrayList = ObjectMapperThingie.fromJson(jsonNode, ArrayList.class);
//        arrayList.forEach(it -> {
//            Employee employee = (Employee) it;
//            System.err.println("E: " + employee.getName());
//        });
    }
}