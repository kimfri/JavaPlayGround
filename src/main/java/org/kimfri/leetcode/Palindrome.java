package org.kimfri.leetcode;

public class Palindrome {

    public boolean isPalindrome(int x) {
        String xString = Integer.toString(x);
        byte[] value = xString.getBytes();
        for (int i = 0; i < value.length / 2; i++) {
            if(value[i] != value[value.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}