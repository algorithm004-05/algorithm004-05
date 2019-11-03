/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public:
    vector<vector<int>> levelOrder(Node* root)
    {
        if (!root) {    //检查树是否为空
            return {};
        }
        queue<Node*> q;  //建立一个queue来存储树中的结点
        q.push(root);
        vector<vector<int>> ans;  //存储最后的输出结果
        while (!q.empty()) {      //队列中会依次把所有的结点push进去，如果检查到队列空了，说明已经遍历了整个树的所有结点
            int s = q.size();
            vector<int> current;           //存储每一层的val值
            for (int i = 0; i < s; ++i) {  //s的值是这一层有几个结点的数据需要存储
                Node* tmp;
                tmp = q.front();
                q.pop();                        //记录了队列的首结点的val后把这个结点从队列中删除
                current.push_back(tmp->val);    //把每一层的不同的结点中的valpush到current中
                for (auto i : tmp->children) {  //把每一个tmp的儿子结点push到队列中
                    q.push(i);
                }
            }
            ans.push_back(current);
        }
        return ans;
    }
};
/*
Accepted
36/36 cases passed (200 ms)
Your runtime beats 83.9 % of cpp submissions
Your memory usage beats 64.37 % of cpp submissions (33.8 MB)
*/