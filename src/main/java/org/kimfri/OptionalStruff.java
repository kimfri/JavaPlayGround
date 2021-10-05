package org.kimfri;

import java.util.Optional;

public class OptionalStruff {
    public static void main(String[] args) {
        OptionalStruff ft = new OptionalStruff();
        ft.doit();
    }

    private void doit() {
        Optional<Boolean> aBoolean = giveMeABoolean(true);

        String not_a_value = aBoolean.map(this::giveMeAString)
                .orElse("Not A value");
        System.out.println(not_a_value);

    }

    String giveMeAString(boolean aBool) {
        return "" + aBool;
    }

    Optional<Boolean> giveMeABoolean(boolean aBool) {
        return aBool ? Optional.of(true) : Optional.empty();
    }
}
