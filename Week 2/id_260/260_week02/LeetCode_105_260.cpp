//1.前序中序构造二叉树

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//大佬的非递归做法，厉害
class Solution {
public:
    TreeNode* buildTree(vector<int>& pre, vector<int>& in) {
    if (pre.empty()) return NULL;
    stack<TreeNode*> S;
    TreeNode* root = new TreeNode(pre[0]);
    S.push(root);
    for (int i = 1, j = 0; i < pre.size(); i++) {  // i-前序序号，j-中序序号
    TreeNode *back = NULL, *cur = new TreeNode(pre[i]);
    while (!S.empty() && S.top()->val == in[j]) back = S.top(), S.pop(), j++;
    if (back)
      back->right = cur;
    else
      S.top()->left = cur;
    S.push(cur);
    }
  return root;
    }
};
//递归做法
class Solution {
public:
    map<int, int> idx;
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int& pre_idx, int inleft, int inright){
        if(inleft == inright)
            return NULL;
        
        int root_val = preorder[pre_idx];
        TreeNode* root = new TreeNode(root_val);
        
        int index = idx[root_val];
        
        pre_idx++;
        
        root->left = helper(preorder, inorder, pre_idx, inleft, index);
        
        root->right = helper(preorder, inorder, pre_idx, index + 1, inright);
        
        return root;
        
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++){
            idx[inorder[i]] = i;
        }
        int pre_idx = 0;
        return helper(preorder, inorder, pre_idx, 0, inorder.size());
    }
};

