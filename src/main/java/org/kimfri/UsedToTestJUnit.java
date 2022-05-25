package org.kimfri;

import java.util.List;

public class UsedToTestJUnit {

    /**
     * This is what the method should do...
     *
     * @param values List<Integer> the data that should be handeled
     * @return int max value of the inserted values
     */
    public int getLargestValue(List<Integer> values) {
        return values.stream()
                .filter(it -> it % 2 == 0)
                .mapToInt(v -> v)
                .max()
                .orElse(-1);
    }
}
