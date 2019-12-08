import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Totem
 * @version www.tuten.top 2019/10/27 19:49
 */
public class LeetCode {

    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();

        leetCode.ectopicWord1("asdf", "fdsa");
        leetCode.ectopicWord2("asdf", "fdsa");
    }
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     *  示例 1:
     *      输入: s = "anagram", t = "nagaram"
     *      输出: true
     *
     * 示例 2:
     *      输入: s = "rat", t = "car"
     *      输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     */

    /**
     * 1 确定题意
     * 2 找出最优解 - 时间 空间 复杂度最好
     * 3 写代码
     * 4 测试
     */

    /**
     * 排序
     * 排序后,判断是否相等
     * <p>
     * 复杂度:
     * 时间复杂度：
     * O(n \log n)O(nlogn)，
     * 假设 nn 是 ss 的长度，排序成本 O(n\log n)O(nlogn) 和比较两个字符串的成本 O(n)O(n)。
     * 排序时间占主导地位，总体时间复杂度为 O(n \log n)O(nlogn)。
     * 空间复杂度：
     * O(1)O(1)，
     * 空间取决于排序实现，如果使用 heapsort，通常需要 O(1)O(1) 辅助空间。
     * 注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)O(n) 额外的空间，但是我们忽略了这一复杂性分析，
     * 因为：这依赖于语言的细节。
     * 这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
     */
    public Boolean ectopicWord1(String a, String b) {
        //判断长度是否一致
        if (a.length() != b.length()) {
            return false;
        }
        //转为字符串数组
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        //排序
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    /**
     * 哈希表
     *
     * @param a
     * @param b
     * @return
     */
    public boolean ectopicWord2(String a, String b) {
        //判断长度是否一致
        if (a.length() != b.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < b.length(); i++) {
            counter[a.charAt(i) - 'c']++;
            counter[b.charAt(i) - 'c']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *  输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     */

    /**
     * 递归
     * 时间复杂度：
     * O(n)O(n)。递归函数 T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1
     * 空间复杂度：
     * 最坏情况下需要空间O(n)O(n)，平均情况为O(\log n)O(logn)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root, right, res);
            }
        }
    }


}
