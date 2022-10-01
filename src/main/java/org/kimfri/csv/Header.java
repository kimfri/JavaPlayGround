package org.kimfri.csv;

public enum Header {
    FIRST_NAME("Firstname"),
    LAST_NAME("Lastname"),
    AGE("Age");

    private final String label;

    private Header(String label) {
        this.label = label;
    }
}
