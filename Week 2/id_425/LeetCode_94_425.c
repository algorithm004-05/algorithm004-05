/*
 * @lc app=leetcode.cn id=94 lang=c
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.26%)
 * Likes:    307
 * Dislikes: 0
 * Total Accepted:    69.5K
 * Total Submissions: 101.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int inorderTraversal_1(struct TreeNode* root,int *outList, int *returnSize ){
    if(root){//当前输入根节点存在
        (void) inorderTraversal_1( root->left, outList, returnSize);
        *(outList+(*returnSize)) = root->val;
        (*returnSize)++;
        (void) inorderTraversal_1( root->right, outList, returnSize);
        
    }
    return 0;
}

int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int *outList;
    outList = (int*)malloc(sizeof(int)*101);//100自定义，意思为一个足够长的数字
    *returnSize = 0;
    (void)inorderTraversal_1(root,outList,returnSize);
    return outList; 
}




// @lc code=end

