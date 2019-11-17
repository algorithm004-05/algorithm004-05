# NOTE

本周主要学习了

- 优先搜索：深度，广度
- 贪心算法
- 二分查找
  以上三种均有模板可以套用。

## DFS & BFS

### DFS 递归

public class DeepSearch {

    class Node {

        public Node[] children;

    }

    private Set<Node> visited = new HashSet<>();

    public void dfs(Node node, Set<Boolean> visited) {

        if (visited.contains(node)) {
            // exist in set
            return;

        }

        visited.add(node);

        // process current node

        for (Node node : node.children) {
            if (!visited.contains(node)) {
                dfs(node, visited);
            }
        }
    }

}

### DFS 非递归

public void dfs2(TreeNode tree){

        if(tree.root == null){
            return;
        }

        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(tree);


        TreeNode tmp = null;
        while(!stack.isEmpty()){

            tmp = stack.pop();
            visited.add(tmp);

            // Do something


            // Find other related nodes

            //stack.push( nodes)


            // Do some other things


        }
    }

## 贪心算法

贪心算法是一种在每一步选择中都采取单签状态下的最好和最优解（是当前有利），从而希望导致最终的全局最优。 但是一般下无法获取全局最优。担心不带记录和回溯，如果带记录和回溯，就是动态规划。

## 二份查找

1，有序序列进行查找，时间消耗 O(nlog)

left = 0;
right = len(array -1)

while left <= right:
mid = (left + right) /2
if array[mid] == target:
return;
elif array[mid] < target:
left = mid +1;
elif array[mid] > target:
right = mid -1;
