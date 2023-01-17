package org.kimfri.leetcode;

public class LengthOfLastWord {


    public int lengthOfLastWord(String s) {

        return s.trim().substring(s.lastIndexOf(" ") +1).length();

//        String a = s.trim();
//        int index = a.lastIndexOf(" ");
//        String sub = a.substring(index + 1);
//        int len = sub.length();
//        return len;
    }

    public int lengthOfLastWord1(String s) {

        final String[] s1 = s.trim().split(" ");

        return s1[s1.length - 1].length();
    }
}