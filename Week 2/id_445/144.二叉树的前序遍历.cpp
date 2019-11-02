/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 */
#include <stack>
#include <vector>
using namespace std;
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
// solution 1 recursively
    // vector<int> preorderTraversal(TreeNode* root) {
    //     vector<int> res;
    //     recur(root,res);
    //     return res;
    // }
    // void recur( TreeNode* node,vector<int> &res){
    //     if (node==NULL)
    //     {
    //         return;
    //     }
    //     res.push_back(node->val);
    //     recur(node->left,res);
    //     recur(node->right,res);
        
    // }
    // solution2 iteratively
     vector<int> preorderTraversal(TreeNode* root) {
         vector<int> res;
         stack<TreeNode> s;
         while (true)
         {
             while (root)
             {
                 res.push_back(root->val);
                 s.push(*root);
                 root=root->left;

             }
             if(s.empty()) return res;
             root=s.top().right;
             s.pop();
             
         }
         
     }
};
// @lc code=end

