/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
      
       // terminator
       if (root == p || root == q || root == nullptr){
           return root;
       }
       //drill down
       TreeNode *left = lowestCommonAncestor(root->left,  p,  q)  ;
       TreeNode *right = lowestCommonAncestor(root->right,  p,  q)  ;

       //process
       return left == nullptr? right:(right == nullptr? left: root);
       //reverse data

    }
};
// @lc code=end

