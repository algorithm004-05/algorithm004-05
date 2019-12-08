package xyz.isok.algorithm.leetcode.hard;

public class No45JumpGameII {

    public static void main(String[] args) {
//        int[] data = {2, 3, 1, 1, 4};
        int[] data = {2, 3, 1, 4, 1, 2, 1};
//        int[] data = {4,1,1,3,1,1,1};
//        int[] data = {3,1,4,7,1,1,1,1,3,1,1,1};

//        int[] data = {1, 2};
//        System.out.println(new No45JumpGameII().jump(data));
        System.out.println(new No45JumpGameII().jump1(data));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int node = length - 1;
        int count = 0;
        while (node > 0) {
            int endIndex = node;
            for (int i = node; i >= 0; i--) {
                if (nums[i] + i >= endIndex) {
                    if (node > i) {
                        node = i;
                    }
                }
            }
            count++;
        }

        return count;
    }

    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
