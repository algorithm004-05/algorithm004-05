/**
 * created by lchen on 2019/10/27
 */
public class LeetCode_236_535 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();

    }
}

class Solution7 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
    private int dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int mid = root == p || root == q ? 1 : 0;
        if(left + right + mid > 1) res = root;
        return left + right + mid > 0 ? 1 : 0;
    }
}