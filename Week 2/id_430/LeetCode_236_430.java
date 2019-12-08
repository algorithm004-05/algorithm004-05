package id_430;

/**
 * @Author Shuangshuang Wang, <shshwang@mobvoi.com>
 * @Date 2019/10/27
 */
public class LeetCode_236_430 {

  class Solution1 {

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      traverseCommonAncestor(root, p, q);
      return res;
    }

    /**
     * 是否找到p或q中的任意一个
     */
    public boolean traverseCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return false;
      }
      int num = 0;
      if (root.left != null && traverseCommonAncestor(root.left, p, q)) {
        num++;
      }
      if (root.right != null && traverseCommonAncestor(root.right, p, q)) {
        num++;
      }
      if (root == p || root == q) {
        num++;
      }
      // left+right或left+cur或right+cur
      if (num == 2) {
        res = root;
      }
      return num > 0;
    }
  }

  /**
   * 较优的写法
   */
  class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return null;
      }
      // 递归终结，找到了p或q
      if (root == p || root == q) {
        return root;
      }
      TreeNode l = null;
      TreeNode r = null;
      if (root.left != null) {
        // 左子树找到的p或q
        l = helper(root.left, p, q);
      }
      if (root.right != null) {
        // 右子树找到的p或q
        r = helper(root.right, p, q);
      }
      // 左右子树都没找到，则未找到，很重要，放到最前面
      // 左右子树都找到了，则当前节点是结果
      // 只有一个子树找到了，返回该子树找到的结果（此时结果必定是p、q中的一个）
      return (l == null && r == null) ? null : (l != null & r != null) ? root : (l != null) ? l : r;
    }

  }
}
