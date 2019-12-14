/**102. 二叉树的层次遍历
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List curlevel=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.removeFirst();
                curlevel.add(node.val);
                if(node.left!=null){
                    q.addLast(node.left);
                }
                if(node.right!=null){
                    q.addLast(node.right);
                }
            }
            res.add(curlevel);
        }
        return res;
    }
}