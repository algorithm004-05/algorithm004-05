//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：N叉树的前序遍历
public class Week_2_Class_6_4_NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Week_2_Class_6_4_NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    class Solution {
        List<Integer> res = new ArrayList<Integer>();

        public List<Integer> preorder(Node root) {
            inOrder(root);
            return res;
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            int s = root.children.size();
            for (int i = 0; i < s; i++) {
                inOrder(root.children.get(i));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}