/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
 */
#include <vector>
#include <queue>
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
    
//solution 1 loop
//     vector<int> inorderTraversal(TreeNode* root) {
//         stack<TreeNode > rec;
//         vector<int> res;
//         TreeNode  * cur=root;

        
//         while (cur || !rec.empty())
//         {

//             while(cur!=NULL){
//             rec.push(*(cur));
//             cur=cur->left;
//             }
            
//                 if(!rec.empty()){
//                 res.push_back(rec.top().val);
//                 cur=rec.top().right;
//                 rec.pop(); 
//                 }
//         }
            
//         return res;

//     }
// };
// solution 2 recursion
 vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode > rec;
        vector<int> res;
        TreeNode  * cur=root;

        recur(cur,res);
            
        return res;

    }
    void recur(TreeNode* node,vector<int> & res){
        if (node==NULL)
        {
            return ;
        }
        recur(node->left,res);
        res.push_back(node->val);
        recur(node->right,res);
    }
};

// @lc code=end

