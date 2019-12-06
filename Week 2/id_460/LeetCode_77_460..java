package week2.Lesson7.Question77Combine;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * */
public class Combine {
    static int n;
    static  int k;
    static  List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        n = 4;
        k = 2;
        result = combine(n,k);
        System.out.println(result);

    }
    public static void backTrack(int first,LinkedList<Integer> curr){
        if (curr.size() ==k){
            result.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n+1; ++i) {
            curr.add(i);
            backTrack(i+1,curr);
            curr.removeLast();
        }
    }
    public static List<List<Integer>>combine(int n,int k){
        backTrack(1,new LinkedList<Integer>());
        return result;
    }
}
