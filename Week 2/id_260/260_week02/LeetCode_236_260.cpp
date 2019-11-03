///1.二叉树的最近公共祖先
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

 //这个题不会，看了大佬的答案，好玄妙啊，真的想不到

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || root == p || root == q){return root; }
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        return left == nullptr? right : (right == nullptr? left : root); 
    }
};
//递归，对每个节点对应的子树，若该子树不含有p或q，返回nullptr；否则，如果p和q分别位于当前子树根节点两侧，则返回当前节点，否则（p和q在同一侧，或者只有某一侧有p或q）返回来自左边或右边的LCA。

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        int dummy = contain_counter(root, p, q);
        return ans;
    }
    int contain_counter(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root) return 0;
        int mid = 0;
        if (root == p || root == q) mid = 1;
        int left = contain_counter(root->left, p, q);
        if (mid + left == 2) {  //可能的话提前剪枝，避免无意义的遍历
            if (!ans) ans = root;
            return 2;
        }
        int right = contain_counter(root->right, p, q);
        if (left + right + mid == 2) if (!ans) ans = root;
        return left + right + mid;
    }
private:
    TreeNode* ans = nullptr;
};
//递归，中序遍历，对每个节点，计算其左子树和右子树包含的p或q个数，并返回。第一个包含2个目标值的子树对应的根节点就是最低公共祖先。