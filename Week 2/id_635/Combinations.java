package com.simon.leetcode.lcn77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private ArrayList<List<Integer>> res;

    private void generateCombinations(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            generateCombinations(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        generateCombinations(n, k, 1, list);

        return res;

    }

}
