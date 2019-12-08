//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：N叉树的后序遍历
public class Week_2_Class_6_3_NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Week_2_Class_6_3_NAryTreePostorderTraversal().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    class Solution {
        List<Integer> res = new ArrayList<Integer>();
        public List<Integer> postorder(Node root) {
            helper(root);
            return res;
        }

        public void helper(Node root) {
            if (root == null) {
                return;
            }
            int s = root.children.size();
            for (int i = 0; i < s; i++) {
                helper(root.children.get(i));
            }
            res.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}