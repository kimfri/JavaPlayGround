package org.kimfri.leetcode;

public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String strPrefix = strs[0];

        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(strPrefix) != 0) {
                strPrefix = strPrefix.substring(0, strPrefix.length() - 1);
                if (strPrefix.isEmpty()){
                    return "";
                }
            }
        return strPrefix;
    }




    int getMinLengthOfStrings(String[] strs) {
        int minLen = 100;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        return minLen;
    }
}
