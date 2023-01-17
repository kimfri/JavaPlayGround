package org.kimfri.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddDigits {
    public int addDigits(int num) {
        while (("" + num).length() > 1) {
            final Integer sum = getAllParts(num).stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            num = sum;
        }

        return num;
    }

    List<Integer> getAllParts(int value) {
        List<Integer> ints = new ArrayList<>();
        String s = "" + value;
        for (char c : s.toCharArray()) {
            String p = String.valueOf(c);
            ints.add(Integer.parseInt(p));
        }
        return ints;
    }
}
