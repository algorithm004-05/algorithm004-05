//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

import java.util.List;

//Java：三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> trgl) {
            int sz = trgl.size();
            int[] results = new int[sz + 1];

            for (int i = sz - 1; i >= 0; i--) {
                List<Integer> tmp = trgl.get(i);

                for (int j = 0; j < tmp.size(); j++) {
                    results[j] = Math.min(results[j], results[j + 1]) + tmp.get(j);
                }
            }
            return results[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}