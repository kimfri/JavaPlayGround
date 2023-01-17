package org.kimfri.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
           if(map.putIfAbsent(i, i) != null) {
               return true;
           }
        }
        return false;
    }
}
