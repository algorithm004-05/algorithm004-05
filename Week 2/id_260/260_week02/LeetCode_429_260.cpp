//1.N叉树的层序遍历

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
    vector<vector<int>> levelOrder(Node* root) {
      if (root == NULL) {
          return vector<vector<int>> ();
      }  
        vector<vector<int>> res;
        queue<Node*> que;
        que.push(root);
        int count = 1;
        while (que.size()) {
            vector<int> temp;
            int inner_count = 0;
            while (count > 0) {
                Node* node = que.front();
                que.pop();
                temp.push_back(node->val);
                count -= 1;
                for (auto rt : node->children) {
                    que.push(rt);
                    inner_count += 1;
                }
            }
            res.push_back(temp);
            count = inner_count;
        }
        return res;
    }
};