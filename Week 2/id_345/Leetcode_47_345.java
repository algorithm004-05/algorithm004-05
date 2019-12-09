package xyz.isok.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No47PermutationsII$1 {

    List<List<Integer>> lists = new ArrayList<>();

    List<String> set = new ArrayList<>();

    int[] nums = null;

    int last = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        last = nums.length - 1;
        this.nums = nums;
        backTrace(0);
        return lists;
    }

    private void backTrace(int first) {
        for (int i = first; i < nums.length; i++) {
            if (first == last) {
                List<Integer> list = toList();
                String mark = toMark(list);
                if (!set.contains(mark)){
                    set.add(mark);
                    lists.add(list);
                }
            } else {
                swap(first, i);
                backTrace(first + 1);
                swap(first, i);
            }
        }
    }

    private String toMark(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }

    private void swap(int first, int i) {
        if (first != i) {
            int temp = nums[first];
            nums[first] = nums[i];
            nums[i] = temp;
        }
    }

    private List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }



}
