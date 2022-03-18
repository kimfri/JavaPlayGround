package org.kimfri;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalStruffTest {

    @Test
    void optionalWithList() {
//        final List<CoolThing> coolThings = Arrays.asList(
//                new CoolThing(1),
//                new CoolThing(2)
//        );
        final List<CoolThing> coolThings = null;
        final List<CoolThing> coolThings1 = Optional.ofNullable(coolThings)
                .orElse(new ArrayList<>());
        final Integer integer = coolThings1.stream()
                .map(CoolThing::getSize)
                .findFirst()
                .orElse(99);
        assertEquals(1, integer);
        final OptionalStruff optionalStruff = new OptionalStruff();
    }

    @Test
    void optionalWithList2() {
        assertEquals(99, getValueFromList(null));
        List<CoolThing> coolThings = new ArrayList<>();
        assertEquals(99, getValueFromList(coolThings));
        coolThings.add(new CoolThing(1));
        coolThings.add(new CoolThing(2));
        assertEquals(1, getValueFromList(coolThings));
    }

    int getValueFromList(List<CoolThing> coolThings) {
        return Optional.ofNullable(coolThings)
                .orElse(new ArrayList<>())
                .stream()
                .map(CoolThing::getSize)
                .findFirst()
                .orElse(99);
    }

    public class CoolThing {
        private int size;

        public CoolThing(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }


}