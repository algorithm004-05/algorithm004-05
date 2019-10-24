# NOTE
## hash map
* hash value:
key -> hash function -> value % n -> index
* hash collisions: same value after hash function. => linked list
* read the source code of `dict()` and `set()` in python.
* using ASIIC code with a list can be a simplified hash map for characters.

## Tree, Binary tree, Binary Search Tree
* a special linked list -> a tree, a special tree (with cycle) -> a graph
* Preorder, Inorder, Postorder traversal. Time complexity O(n)
* BST: search, insert, delete 

## Recursion
Template: def recur(level, param)
1. if level > MAX: return (recursion ending condition)
2. process(level, param) (current level logic)
3. recur(level+1, new_param) (go to next level)
4. restore current status (clean current level if needed)

## Notes on the leetcode problems
### Problem 242
when building your own counter to count the frequency in each string,
remember that two dictionaries with same key, value pairs but in different orders are equal.
```Python
{"a":1, "b":2} == {"b":2, "a":1} is True
```
worth reading the implementation of dictionary in python and figuring out why

### Problem 236
I need a better understanding of equality of objects in python.
