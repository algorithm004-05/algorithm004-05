/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
 */
#include <vector>
#include <stack>
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
// solution1 recursively
    // TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    //    if(root==nullptr || root==p||root==q) return root;
    //     TreeNode* left=lowestCommonAncestor(root->left,p,q);
    //     TreeNode* right=lowestCommonAncestor(root->right,p,q);
 
    //     return left==nullptr?right:(right==nullptr?left:root);
        
    // }
    //solution2 search pah
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode *> path_a,path_b;
        if(!getPath(root,p,path_a)||!getPath(root,q,path_b)) return nullptr;
        int i = 1;
        int size=path_a.size()<path_b.size()?path_a.size():path_b.size();
        for (; i < size; i++)
        {
            if(path_a[i]!=path_b[i]) return path_a[i-1];
        }
        return path_a[i-1];
        
    }
    bool getPath(TreeNode* node,TreeNode * p,vector<TreeNode *> &path){
        if (node)
        {
           path.push_back(node);
           if(node==p) return true;
           if(getPath(node->left,p,path)) return true;
           if(getPath(node->right,p,path)) return true;
           path.pop_back();
           return false;
        }
        return false;
        
    }
};
// @lc code=end

