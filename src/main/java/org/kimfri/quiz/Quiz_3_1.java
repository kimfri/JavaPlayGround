package org.kimfri.quiz;

public class Quiz_3_1 {
    public static void main(String[] args) {
        Quiz_3_1 quiz  = new Quiz_3_1();
        final int[] nums = new int[]{2, 7, 11, 15};
        final int target = 9;
        final int[] indices = quiz.doit(nums, target);
//        output [0, 1]

        for (int i = 0; i < indices.length; i++) {
            System.err.println(i);
        }
    }

    /*
    The two indices that sums up to target
     */
    int[] doit(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }
}
