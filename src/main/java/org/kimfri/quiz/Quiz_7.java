package org.kimfri.quiz;

/*
 * A - None
** B - 1 2 3 5
 * C - 1235
 * D - 12345
 */
public class Quiz_7 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4,5 };
        for (int i = 0; i < nums.length; i++) {
            if (i == 3)
                i = i +1;
            System.err.print(" " + nums[i]);
        }
    }
}
