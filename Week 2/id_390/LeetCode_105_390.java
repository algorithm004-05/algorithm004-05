//根据一棵树的前序遍历与中序遍历构造二叉树。 
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



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 1. 递归  时间O(n) 空间O(n)
class Solution {
    int pre_idx = 0;
    int[] preorder = null;
    int[] inorder = null;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length, map);
    }

    private TreeNode helper (int left, int right, Map<Integer, Integer> map) {
        if (left == right) {
            return null;
        }
        int val = preorder[pre_idx];
        TreeNode root = new TreeNode(val);
        int in_idx = map.get(val);
        pre_idx++;
        root.left = helper(left, in_idx, map);
        root.right = helper(in_idx + 1, right, map);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
