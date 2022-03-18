package org.kimfri.lambdathings;


import lombok.NonNull;

import java.util.Optional;
import java.util.function.Consumer;

public class LambdaThingies {

    void addNewItemToList(@NonNull final String branchName, Consumer<Branch> consumer) {
        final Branch branch = new Branch(branchName);
        consumer.accept(branch);
    }

    public Optional<String> getAString(boolean choice) {
        return choice ? Optional.of("A String") : Optional.empty();
    }

    public static class Branch {
        private final String name;

        public Branch(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
