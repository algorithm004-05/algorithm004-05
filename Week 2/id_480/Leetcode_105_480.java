package leetcode.editor.cn;//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

import java.util.HashMap;
import java.util.Map;

public class Leetcode_105_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_105_480().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        int preIdx = 0;
        int[] preOrder;
        int[] inOrder;

        Map<Integer, Integer> idxMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preOrder = preorder;
            this.inOrder = inorder;
            int idx = 0;
            for (Integer val : inorder) {
                idxMap.put(val, idx++);
            }
            return helper(0, inorder.length);
        }

        public TreeNode helper(int inLeft, int inRight) {
            //没有元素来构造这个树
            if (inLeft == inRight) {
                return null;
            }
            // 从前序遍历中获取一个元素，作为父节点
            int rootVal = preOrder[preIdx];
            TreeNode root = new TreeNode(rootVal);
            //
            int index = idxMap.get(rootVal);

            preIdx++;

            root.left = helper(inLeft, index);

            root.right = helper(index + 1, inRight);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}