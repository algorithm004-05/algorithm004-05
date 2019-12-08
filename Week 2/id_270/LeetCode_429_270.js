let root = {
  "$id": "1",
  "children": [
    {
      "$id": "2",
      "children": [
        { "$id": "5", "children": [], "val": 5 },
        { "$id": "6", "children": [], "val": 6 }
      ],
      "val": 3
    },
    {
      "$id": "3",
      "children": [],
      "val": 2
    },
    { "$id": "4", "children": [], "val": 4 }], "val": 1
}

function search(node, result, level) {
  if (node !== null) {
    if (!result[level]) result[level] = []
    result[level].push(node.val)
    for (var j = 0; j < node.children.length; j++) {
      search(node.children[j], result, level + 1);
    }
  }
}

var levelOrder = function (root) {
  var result = [];
  search(root, result, 0);
  return result;
};

console.log(levelOrder(root))