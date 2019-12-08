package xyz.isok.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No77combinations {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, 1, k, new LinkedList<>());
        return lists;
    }

    private void combine(int max, int cursor, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = cursor; i <= max; i++) {
            list.add(i);
            combine(max, i + 1, k, list);
            list.removeLast();
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

}
