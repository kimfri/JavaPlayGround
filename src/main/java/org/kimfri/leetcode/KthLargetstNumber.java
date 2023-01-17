package org.kimfri.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargetstNumber {

    public String kthLargestNumber(String[] nums, int k) {

        return Arrays.stream(nums)
                .map(BigInteger::new)
                .sorted()
                .collect(Collectors.toList())
                .get(nums.length-k).toString();
    }
}
