/**515. 在每个树行中找最大值
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int max=q.getFirst().val;
            for(int i=0;i<size;i++){
                TreeNode node=q.removeFirst();
                if(node.val>max){
                    max=node.val;
                }
                if(node.left!=null){
                    q.addLast(node.left);
                }
                if(node.right!=null){
                    q.addLast(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}