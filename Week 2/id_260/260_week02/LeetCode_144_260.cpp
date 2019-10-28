//1.二叉树的前序遍历
/*
 *Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    vector<int> ret;
    vector<int> preorderTraversal(TreeNode* root) {
        pre_travel(root);
        return ret;
    }
    void pre_travel(TreeNode* root)
    {
        if(root)//当前结点非空
        {
            ret.push_back(root->val);//访问根节点
            pre_travel(root->left);//递归左子树
            pre_travel(root->right);//递归右子树
        }
    }
};