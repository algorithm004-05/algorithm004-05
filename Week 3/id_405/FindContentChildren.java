package geektime.greedy;

import java.util.*;

public class FindContentChildren {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int contents = 0;int j = 0;int i = 0;
            //每个孩子按照胃口从小到大顺序排队，拿取满足自己胃口的最小饼干，直至拿到最后一块饼干
            while (i < g.length) {
                if (j >= s.length) break;
                if (s[j] >= g[i]) {
                    contents++;
                    j++;i++;
                } else {
                    j++;
                }
            }
            return contents;
        }
    }
}
