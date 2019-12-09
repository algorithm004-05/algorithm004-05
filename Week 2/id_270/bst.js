class Node {
  constructor(data, left, right) {
    this.data = data
    this.left = left
    this.right = right
  }
  show() {
    return this.data
  }
}

class BST {
  constructor() {
    this.root = null
  }
  /**
   *  中序遍历: 升序
   *  左子树  -> 根节点 -> 右子树
   */
  inOrder(node) {
    if (!(node == null)) {
      this.inOrder(node.left);
      console.log(node.show() + " ");
      this.inOrder(node.right);
    }
  }
  /**
   *  根节点 -> 左子树 -> 右子树
   */
  preOrder(node) {
    if (!(node == null)) {
      console.log(node.show() + " ");
      this.preOrder(node.left);
      this.preOrder(node.right);
    }
  }
  /**
   *  左子树 -> 右子树 -> 根节点 
   */
  postOrder(node) {
    if (!(node == null)) {
      this.postOrder(node.left);
      this.postOrder(node.right);
      console.log(node.show() + " ");
    }
  }

  insert(data) {
    var n = new Node(data, null, null);
    if (this.root == null) {
      this.root = n;
    } else {
      var current = this.root;
      var parent;
      while (true) {
        parent = current;
        if (data < current.data) {
          current = current.left;
          if (current == null) {
            parent.left = n;
            break;
          }
        } else {
          current = current.right;
          if (current == null) {
            parent.right = n;
            break;
          }
        }
      }
    }
  }

  getMax() {
    var current = this.root
    if (current === null) {
      console.log('empty tree')
      return null
    }
    while (current.right !== null) {
      current = current.right
    }
    return current.data
  }

  getMin() {
    var current = this.root
    if (current === null) {
      console.log('empty tree')
      return null
    }
    while (current.left !== null) {
      current = current.left
    }
    return current.data
  }

  find(data) {
    var current = this.root
    while (current !== null) {
      if (data === current.data) {
        return current
      } else if (data < current.data) {
        current = current.left
      } else {
        current = current.right
      }
    }
    return null
  }

  remove(data) {
    removeNode(this.root, data);
  }

  removeNode(node, data) {
    if (node === null) {
      return null;
    }
    if (data === node.data) {
      // 没有子节点的节点
      if (node.left === null && node.right === null) {
        return null;
      } // 没有左子节点的节点
      if (node.left == null) {
        return node.right;
      } // 没有右子节点的节点
      if (node.right == null) {
        return node.left;
      } // 有两个子节点的节点
      var tempNode = this.getMin(node.right);
      node.data = tempNode.data;
      node.right = this.removeNode(node.right, tempNode.data);
      return node;
    } else if (data < node.data) {
      node.left = this.removeNode(node.left, data);
      return node;
    } else {
      node.right = this.removeNode(node.right, data);
      return node;
    }
  }
}
var nums = new BST();
nums.insert(23);
nums.insert(45);
nums.insert(16);
nums.insert(37);
nums.insert(3);
nums.insert(99);
nums.insert(22);

console.log(nums.getMin())
console.log(nums.getMax())
console.log(nums.find(23))

// nums.postOrder(nums.root)