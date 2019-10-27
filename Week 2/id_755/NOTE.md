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
```python
def recursion(level, param1, param2, ...):
    # ending condition
    if level > MAX_LEVEL:
        process_result
        return
    # process logic in current level
    process(level, data)
    
    # drill down
    self.recursion(level+1, p1, ...)
    
    # reverse the current level status if needed
```

## divide-and-conquer / backtracking
Template
```python
def divide_conquer(problem, param1, param2, ...):
    # recursion ending condition
    if problem is None:
        print_result
        return
    # prepare data
    data = preapare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)
```

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