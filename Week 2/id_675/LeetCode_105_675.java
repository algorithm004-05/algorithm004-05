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

import javax.swing.tree.TreeNode;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< inorder.length;i++){
            map.put(inorder[i],i);
        }

        /**
         * 根据
         */

    }

    private Treenode helper(int[] preorder,int[] inorder,int begin,int end ,int pre){

       if (begin == end) return null;


       TreeNode treeNode = new TreeNode(preorder[pre]);


       treeNode.left = helper(preorder,inorder,)


        if (map.get(preorder[1]) > map.get(pre)){
            helper(node,preorder.);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
