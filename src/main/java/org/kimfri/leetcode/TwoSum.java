package org.kimfri.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.one();
    }

    private void one() {
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        int[] nums = new int[]{2, 7, 11, 16};
        int target = 9;
        final int[] ints = twoSum2(nums, target);
        for (int anInt : ints) {
            System.err.println(anInt);
        }
    }


    public int[] twoSum2(int[] nums, int target) {

        //   value,   index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = target - nums[i];
            if(map.containsKey(currentValue)) {
                return new int[]{map.get(currentValue), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
