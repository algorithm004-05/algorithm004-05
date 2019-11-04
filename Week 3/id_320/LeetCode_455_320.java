package lesson.week.three;

import java.util.Arrays;

/**
 * Created by liangwj20 on 2019/11/03 09:01
 * Description: 分发饼干
 */
public class LeetCode_455_320 {

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,2,3}));
    }

    private static int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if(g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

}
