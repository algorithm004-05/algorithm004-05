class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            result.add(top.val);
            if(null != top.right){
                stack.push(top.right);
            }
            if(null != top.left){
                stack.push(top.left);
            }
        }
        return result;
    }
}