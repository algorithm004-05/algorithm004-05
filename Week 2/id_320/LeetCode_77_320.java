package lesson.week.two;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liangwj20 on 2019/10/27 18:01
 * Description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class LeetCode_77_320 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, 0, new LinkedList<>(), n, k);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int level, LinkedList<Integer> curr, int n, int k) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
            return;
        }
        for (int i = level; i < n; ++i) {
            curr.add(i + 1);
            backtrack(res,i + 1, curr, n ,k);
            curr.removeLast();
        }
    }

}
