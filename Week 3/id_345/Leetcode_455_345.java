package xyz.isok.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class No455AssignCookies {

    public static void main(String[] args) {
//        int[] g = {1,2,3};
//        int[] s = {1,1};

        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(new No455AssignCookies().findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0){
            return 0;
        }
        if (s == null || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int max = s.length;
        int j = 0;
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < max){
                if (s[j++] >= g[i]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
