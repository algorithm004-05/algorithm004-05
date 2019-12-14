/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
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
    vector<int> ans;
    vector<int> inorderTraversal(TreeNode* root)
    {
        //vector<int> ans;  不能把这个放在这，因为每次都会调用递归函数，会重新建立一个ans
        if (root) {
            inorderTraversal(root->left);  //递归，再次调用inorderTraversal函数
            ans.push_back(root->val);
            inorderTraversal(root->right);
        }
        return ans;
    }
};
/*
Accepted
68/68 cases passed (8 ms)
Your runtime beats 34.56 % of cpp submissions
Your memory usage beats 5.26 % of cpp submissions (11.1 MB)
*/