/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
 
// 深度优先搜索
var levelOrder = function(root) {
  var result = [];
  
  function dfs(node, level) {
      if (node === null) return;
      
      if (level >= result.length) result.push([]);
      result[level].push(node.val);
      
      dfs(node.left, level + 1);
      dfs(node.right, level + 1);
  }
  
  dfs(root, 0);
  return result;
};

// 广度优先搜索
var levelOrder = function(root) {
  if(!root) return [];
  var result = [], queue = [ root ];
  
  while(queue.length) {
      var curr_level = [], size = queue.length;
      
      for (var i = 0; i < size; i++) {
          var node = queue.shift();
          curr_level.push(node.val);
          if (node.left) queue.push(node.left);
          if (node.right) queue.push(node.right);
      }
      result.push(curr_level);
  }
  return result;
};