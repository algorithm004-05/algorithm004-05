package com.geek.lee.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */
public class Combine_77 {
    private int n;
    private int k;
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return res;
    }

    /**
     * 解法1. 回溯法
     * @param start
     * @param cur
     */
    private void backtrack(int start, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            // 理论上,这块如果进来的话 说明元素已经组合成功了.不需要向下进行了.可以直接返回了
            // 但是加了return要比不加耗时更长?
            return;
        }

        for (int i = start; i <= n; i ++) {
            // 加入到组合list
            cur.add(i);
            // 继续向下获取下一个数
            backtrack(i + 1, cur);
            // 移除掉最后一个元素
            cur.removeLast();
        }
    }
}
