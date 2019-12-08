# NOTE

## 第 13 课 字典(Tire)树和并查集

Tire 树模板

```js
var Trie = function() {
  // 表示是否是单词的末尾
  this.end = false;
  // Map <letter, new Trie()>
  this.links = new Map();
};

Trie.prototype.insert = function(word) {
  let tire = this;
  let links = tire.links;

  for (let i = 0; i < word.length; i++) {
    if (!links.has(word[i])) links.set(word[i], new Trie());
    trie = links.get(word[i]);
    links = trie.links;
  }

  trie.end = true;
};

Trie.prototype.search = function(word) {
  let tire = this;
  let links = tire.links;

  for (let i = 0; i < word.length; i++) {
    if (!links.has(word[i])) return false;
    tire = links.get(word[i]);
    links = tire.links;
  }

  return tire.end;
};

Trie.prototype.startsWith = function(prefix) {
  let links = this.links;

  for (let i = 0; i < prefix.length; i++) {
    if (!links.has(prefix[i])) return false;
    links = links.get(prefix[i]).links;
  }

  return true;
};
```

实现一个 Tire 树

https://leetcode-cn.com/problems/implement-trie-prefix-tree/

// Trie 树

```js
/**
 * Initialize your data structure here.
 */
var Trie = function() {
  // 表示是否是单词的末尾
  this.end = false;
  // Map <letter, new Trie()>
  this.links = new Map();
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
  let tire = this;
  let links = tire.links;

  for (let i = 0; i < word.length; i++) {
    if (!links.has(word[i])) links.set(word[i], new Trie());
    trie = links.get(word[i]);
    links = trie.links;
  }

  trie.end = true;
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
  let tire = this;
  let links = tire.links;

  for (let i = 0; i < word.length; i++) {
    if (!links.has(word[i])) return false;
    tire = links.get(word[i]);
    links = tire.links;
  }

  return tire.end;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
  let links = this.links;

  for (let i = 0; i < prefix.length; i++) {
    if (!links.has(prefix[i])) return false;
    links = links.get(prefix[i]).links;
  }

  return true;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
```

https://leetcode-cn.com/problems/word-search-ii/submissions/

回溯

```js
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
// 回溯
var findWords = function(board, words) {
  let res = [],
    rows = board.length,
    cols = board[0].length;

  // 找到首字母
  for (let w = 0; w < words.length; w++) {
    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        if (
          words[w][0] === board[i][j] &&
          backtrack(i, j, 0, words[w], JSON.parse(JSON.stringify(board))) // clone board
        ) {
          if (res.indexOf(words[w]) === -1) res.push(words[w]);
        }
      }
    }
  }

  function backtrack(i, j, level, word, board) {
    // 终止条件
    if (level === word.length - 1) {
      return true;
    }

    let tmp = board[i][j];

    // 标记为已访问
    board[i][j] = false;

    // 朝四个方向下探
    if (j + 1 < cols && word[level + 1] === board[i][j + 1]) {
      return backtrack(i, j + 1, level + 1, word, board);
    } else if (j - 1 >= 0 && word[level + 1] === board[i][j - 1]) {
      return backtrack(i, j - 1, level + 1, word, board);
    } else if (i - 1 >= 0 && word[level + 1] === board[i - 1][j]) {
      return backtrack(i - 1, j, level + 1, word, board);
    } else if (i + 1 < rows && word[level + 1] === board[i + 1][j]) {
      return backtrack(i + 1, j, level + 1, word, board);
    } else {
      return false;
    }

    // 恢复状态
    board[i][j] = tmp;
  }

  return res;
};
```

trie 树

```js
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
// Trie 树
/**
 * Initialize your data structure here.
 */
var Trie = function() {
  // 表示是否是单词的末尾
  this.end = false;
  // Map <letter, new Trie()>
  this.links = new Map();
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
  let tire = this;
  let links = tire.links;

  for (let i = 0; i < word.length; i++) {
    if (!links.has(word[i])) links.set(word[i], new Trie());
    trie = links.get(word[i]);
    links = trie.links;
  }

  trie.end = true;
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
  let tire = this;
  let links = this.links;

  for (let i = 0; i < word.length; i++) {
    if (!links.has(word[i])) return false;
    tire = links.get(word[i]);
    links = tire.links;
  }

  return tire.end;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
  let links = this.links;

  for (let i = 0; i < prefix.length; i++) {
    if (!links.has(prefix[i])) return false;
    links = links.get(prefix[i]).links;
  }

  return true;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

var findWords = function(board, words) {
  let trie = new Trie();

  for (let i = 0; i < words.length; i++) {
    trie.insert(words[i]);
  }

  let rows = board.length,
    cols = board[0].length,
    res = [];

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      helper(i, j, JSON.parse(JSON.stringify(board)), board[i][j]);
    }
  }

  function helper(i, j, board, letters) {
    // 注意终止条件, （也可以区单词列表中最长单词），我用的是整个 board 的大小，因为用过的字母不能再用
    if (letters.length > cols * rows) {
      return;
    }

    // 在搜索过程中，会出现，连续有效的 word 例如 app apple, 所以只有遍历完成后
    if (trie.search(letters)) {
      if (res.indexOf(letters) === -1) res.push(letters);
    }

    let tmp = board[i][j];

    // 记录访问过的
    board[i][j] = false;

    if (trie.startsWith(letters) && j + 1 < cols) {
      helper(i, j + 1, board, letters + board[i][j + 1]);
    }
    if (trie.startsWith(letters) && j - 1 >= 0) {
      helper(i, j - 1, board, letters + board[i][j - 1]);
    }
    if (trie.startsWith(letters) && i + 1 < rows) {
      helper(i + 1, j, board, letters + board[i + 1][j]);
    }
    if (trie.startsWith(letters) && i - 1 >= 0) {
      helper(i - 1, j, board, letters + board[i - 1][j]);
    }

    board[i][j] = tmp;
  }

  return res;
};
```

### 并查集

适用场景
组团和配对问题

基本操作
makeSet(s): 建立一个并查集，其中包含 s 个单元素
unionSet(x, y): 把元素 x 和 元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交， 如果相交不合并
find(x): 找到元素 x 所在的集合的代表， 该操作也可以判断两个元素是否位于同一个集合，只要将他们各自代表比较一下就可以

查询, 合并
路径压缩

代码模板

```js
function UnionFind(n) {
  this.count = n;
  this.parent = [];
  for (let i = 0; i < n; i++) {
    this.parent[i] = i;
  }
}

UnionFind.prototype.find = function(p) {
  while (p !== this.parent[p]) {
    this.parent[p] = this.parent[this.parent[p]];
    p = this.parent[p];
  }

  return p;
};

UnionFind.prototype.union = function(p, q) {
  let rootP = this.find(p);
  let rootQ = this.find(q);

  if (rootP === rootQ) return;

  this.parent[rootP] = rootQ;

  this.count--;
};
```

https://leetcode-cn.com/problems/friend-circles (?)

并查集 搞定，但完全不理解

```js
function UnionFind(n) {
  this.count = n;
  this.parent = [];
  for (let i = 0; i < n; i++) {
    this.parent[i] = i;
  }
}

UnionFind.prototype.find = function(p) {
  while (p !== this.parent[p]) {
    this.parent[p] = this.parent[this.parent[p]];
    p = this.parent[p];
  }

  return p;
};

UnionFind.prototype.union = function(p, q) {
  let rootP = this.find(p);
  let rootQ = this.find(q);

  if (rootP === rootQ) return;

  this.parent[rootP] = rootQ;

  this.count--;
};

/**
 * @param {number[][]} M
 * @return {number}
 */
// 使用并查集，完全不明白
var findCircleNum = function(M) {
  let n = M.length;
  let uf = new UnionFind(n);

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (M[i][j] === 1) {
        uf.union(i, j);
      }
    }
  }

  return uf.count;
};
```

https://leetcode-cn.com/problems/number-of-islands/（DFS）

DFS

```js
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  let rowLen = grid.length;
  if (!rowLen) return 0;
  let colLen = grid[0].length;
  let dx = [0, 0, 1, -1],
    dy = [1, -1, 0, 0],
    islands = 0;

  for (let i = 0; i < rowLen; i++) {
    for (let j = 0; j < colLen; j++) {
      // 如果是陆地，炸飞， 注意是 字符串 '0'
      if (grid[i][j] === '1') {
        sink(i, j, grid);
        islands++;
      }
    }
  }

  function sink(i, j, grid) {
    // 终止条件
    if (grid[i][j] === '0') {
      return;
    }

    // 处理当前层
    grid[i][j] = '0';

    // 进入下一层
    for (let k = 0; k < dx.length; k++) {
      if (
        i + dx[k] >= 0 &&
        i + dx[k] < rowLen &&
        j + dy[k] >= 0 &&
        j + dy[k] < colLen
      ) {
        sink(i + dx[k], j + dy[k], grid);
      }
    }
  }

  return islands;
};
```

并查集

```js
function UnionFind(n) {
  this.count = n;
  this.parent = [];
  for (let i = 0; i < n; i++) {
    this.parent[i] = i;
  }
}

UnionFind.prototype.find = function(p) {
  while (p !== this.parent[p]) {
    this.parent[p] = this.parent[this.parent[p]];
    p = this.parent[p];
  }

  return p;
};

UnionFind.prototype.union = function(p, q) {
  let rootP = this.find(p);
  let rootQ = this.find(q);

  if (rootP === rootQ) return;

  this.parent[rootP] = rootQ;

  this.count--;
};

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  let rowLen = grid.length;
  if (!rowLen) return 0;
  let colLen = grid[0].length;
  let dx = [0, 0, 1, -1],
    dy = [1, -1, 0, 0],
    islands = 0;

  // 最大的空间 rowLen*colLen
  let uf = new UnionFind(rowLen * colLen + 1);

  getIndex = (i, j) => i * colLen + j;

  for (let i = 0; i < rowLen; i++) {
    for (let j = 0; j < colLen; j++) {
      if (grid[i][j] === '1') {
        // 遍历四个方向，如果是 1 的话，就合并
        for (let k = 0; k < dx.length; k++) {
          if (
            i + dx[k] >= 0 &&
            i + dx[k] < rowLen &&
            j + dy[k] >= 0 &&
            j + dy[k] < colLen &&
            grid[i + dx[k]][j + dy[k]] === '1'
          ) {
            uf.union(getIndex(i, j), getIndex(i + dx[k], j + dy[k]));
          }
        }
      } else {
        // 将所有的水合成一个，所以最后结果要减一
        uf.union(getIndex(i, j), rowLen * colLen + 1);
      }
    }
  }

  return uf.count - 1;
};
```

https://leetcode-cn.com/problems/surrounded-regions/

DFS

```js
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
  let rows = board.length;
  if (rows === 0) return;
  let cols = board[0].length;

  let dx = [0, 0, 1, -1],
    dy = [1, -1, 0, 0];

  // 从边缘开始搜索，如果是 O 则替换成 #
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (
        (i === 0 || j === 0 || i === rows - 1 || j === cols - 1) &&
        board[i][j] === 'O'
      ) {
        dfs(i, j, board, '#');
      }
    }
  }

  function dfs(i, j, board, mark) {
    board[i][j] = mark;
    for (let k = 0; k < 4; k++) {
      if (
        i + dx[k] >= 0 &&
        i + dx[k] < rows &&
        j + dy[k] >= 0 &&
        j + dy[k] < cols &&
        board[i + dx[k]][j + dy[k]] === 'O'
      ) {
        dfs(i + dx[k], j + dy[k], board, mark);
      }
    }
  }

  // 再将内部 O 换成 X
  for (let i = 1; i < rows - 1; i++) {
    for (let j = 1; j < cols - 1; j++) {
      if (board[i][j] === 'O') dfs(i, j, board, 'X');
    }
  }

  // 最后将与边缘连通的 # 换回 O
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (board[i][j] === '#') board[i][j] = 'O';
    }
  }
};
```

## 第 8 课 高级搜索

剪枝, 双向 BFS 和 启发式搜索

初级搜索

1. 朴素搜索
2. 优化方式：不重复（fibonacci），剪枝（生成括号问题）
3. 搜索方向：DFS，BFS，双向搜索（起点和终点分别做 BFS，直到相遇）和启发式搜索（使用优先队列）

https://leetcode-cn.com/problems/climbing-stairs/

傻递归 超时

```js
var climbStairs = function(n) {
  if (n <= 2) {
    return n;
  }

  return climbStairs(n - 1) + climbStairs(n - 2);
};
```

记忆化

```js
let memory = [];

var climbStairs = function(n) {
  if (n <= 2) {
    return n;
  }

  if (!memory[n]) {
    memory[n] = climbStairs(n - 1) + climbStairs(n - 2);
  }

  return memory[n];
};
```

```js
/**
 * dp[n] = dp[n-1] + dp[n-2]
 */

var climbStairs = function(n) {
  if (n <= 2) {
    return n;
  }

  let f1 = 1,
    f2 = 2,
    f3;

  for (let i = 3; i <= n; i++) {
    f3 = f1 + f2;
    f1 = f2;
    f2 = f3;
  }

  return f2;
};
```

https://leetcode-cn.com/problems/generate-parentheses/

```js
/**
 * @param {number} n
 * @return {string[]}
 */
// DFS
var generateParenthesis = function(n) {
  let res = [];

  function helper(left, right, n, level, str) {
    // 终止条件
    if (left === n && right === n) {
      res.push(str);
      return;
    }

    if (left <= n) helper(left + 1, right, n, level + 1, str + '(');
    if (left > right) helper(left, right + 1, n, level + 1, str + ')');
  }

  helper(0, 0, n, 0, '');

  return res;
};
```

BFS

```js
var generateParenthesis = function(n) {
  let res = [];
  let queue = [{ s: '', left: 0, right: 0 }];
  while (queue.length !== 0) {
    let node = queue.shift();
    let { s, left, right } = node;

    if (left === n && right === n) {
      res.push(s);
    }

    if (left < n) {
      queue.push({ s: s + '(', left: left + 1, right });
    }
    if (right < left) {
      queue.push({ s: s + ')', left, right: right + 1 });
    }
  }

  return res;
};
```

https://leetcode-cn.com/problems/n-queens

```js
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let rows = [],
    cols = new Set(),
    pie = new Set(),
    na = new Set(),
    res = [];

  function helper(row, n, currentState) {
    if (row >= n) {
      res.push(currentState);
      return;
    }

    for (let col = 0; col < n; col++) {
      if (cols.has(col) || pie.has(col + row) || na.has(col - row)) {
        continue;
      }

      cols.add(col);
      pie.add(col + row);
      na.add(col - row);

      helper(row + 1, n, [...currentState, col]);

      cols.delete(col);
      pie.delete(col + row);
      na.delete(col - row);
    }
  }

  helper(0, n, []);

  let tmps = [];
  for (let i = 0; i < res.length; i++) {
    let tmp = [];
    for (let j = 0; j < res[i].length; j++) {
      tmp.push(
        new Array(res[i].length)
          .fill('.')
          .fill('Q', res[i][j], res[i][j] + 1)
          .join('')
      );
    }
    tmps.push(tmp);
  }

  return tmps;
};
```

https://leetcode-cn.com/problems/valid-sudoku/description/

```js
/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
  let n = board.length;
  // <number(行号), set<number(数字)>>
  let rows = new Map(),
    cols = new Map(),
    boxes = new Map();

  for (let row = 0; row < n; row++) {
    for (let col = 0; col < n; col++) {
      if (board[row][col] === '.') continue;

      let boxIndex = Math.floor(row / 3) * 3 + Math.floor(col / 3);

      if (!boxes.has(boxIndex)) {
        boxes.set(boxIndex, new Set([board[row][col]]));
      } else {
        let set = boxes.get(boxIndex);
        if (set.has(board[row][col])) {
          return false;
        } else {
          set.add(board[row][col]);
          boxes.set(boxIndex, set);
        }
      }

      if (!rows.has(row)) {
        rows.set(row, new Set([board[row][col]]));
      } else {
        let set = rows.get(row);
        if (set.has(board[row][col])) {
          return false;
        } else {
          set.add(board[row][col]);
          rows.set(row, set);
        }
      }

      if (!cols.has(col)) {
        cols.set(col, new Set([board[row][col]]));
      } else {
        let set = cols.get(col);
        if (set.has(board[row][col])) {
          return false;
        } else {
          set.add(board[row][col]);
          cols.set(col, set);
        }
      }
    }
  }

  return true;
};
```

https://leetcode-cn.com/problems/sudoku-solver/#/description

```js
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */

const getBoxIndex = (row, col) => Math.floor(row / 3) * 3 + Math.floor(col / 3);

var solveSudoku = function(board) {
  let rows = new Map(),
    cols = new Map(),
    boxes = new Map();

  for (let i = 0; i < 9; i++) {
    rows.set(i, new Set());
    cols.set(i, new Set());
    boxes.set(i, new Set());
  }

  let empty = [];

  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      if (board[i][j] !== '.') {
        let rowSet = rows.get(i);
        let colSet = cols.get(j);
        let boxIndex = getBoxIndex(i, j);
        let boxSet = boxes.get(boxIndex);

        rowSet.add(board[i][j]);
        colSet.add(board[i][j]);
        boxSet.add(board[i][j]);

        rows.set(i, rowSet);
        cols.set(j, colSet);
        boxes.set(boxIndex, boxSet);
      } else {
        empty.push({ row: i, col: j });
      }
    }
  }

  // 回溯
  function helper(n, level) {
    // 递归终止条件
    if (level >= n) {
      return true;
    }

    let { row, col } = empty[level];
    let rowSet = rows.get(row);
    let colSet = cols.get(col);
    let boxIndex = getBoxIndex(row, col);
    let boxSet = boxes.get(boxIndex);

    for (let i = 1; i <= 9; i++) {
      let number = i + '';
      if (!rowSet.has(number) && !colSet.has(number) && !boxSet.has(number)) {
        rowSet.add(number);
        colSet.add(number);
        boxSet.add(number);

        board[row][col] = number;

        if (!helper(n, level + 1)) {
          rowSet.delete(number);
          colSet.delete(number);
          boxSet.delete(number);

          board[row][col] = '.';

          rows.set(row, rowSet);
          cols.set(col, colSet);
          boxes.set(boxIndex, boxSet);
        } else {
          return true;
        }
      }
    }

    return false;
  }

  helper(empty.length, 0);
};
```

https://leetcode-cn.com/problems/word-ladder/submissions/

BFS （暂时搞不定，先写个 BFS）

```js
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  let queue = [{ word: beginWord, count: 1 }],
    letters = 'abcdefghijklmnopqrstuvwxyz',
    set = new Set(wordList);

  while (queue.length !== 0) {
    let node = queue.shift();
    let word = node.word;

    if (word === endWord) {
      return node.count;
    }

    for (let i = 0; i < word.length; i++) {
      let f = word.substring(0, i);
      let e = word.substring(i + 1);

      for (let j = 0; j < letters.length; j++) {
        let newWord = f + letters[j] + e;

        if (set.has(newWord)) {
          queue.push({ word: newWord, count: node.count + 1 });
          set.delete(newWord);
        }
      }
    }
  }

  return 0;
};
```

解法 2 双向BFS

```js
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

var ladderLength = function(beginWord, endWord, wordList) {
    if(!wordList.includes(endWord)) return 0

    let sq = [beginWord], eq = [endWord], count = 1
    
    letters = 'abcdefghijklmnopqrstuvwxyz', set = new Set(wordList)

    while (sq.length !== 0) {

        if (sq.length > eq.length) {
            let tmp = sq
            sq = eq
            eq = tmp 
        }

        let size = sq.length

        for (let k=0; k<size; k++) {
            let word = sq.shift()

            for (let i=0; i<word.length; i++) {
                let f = word.substring(0, i)
                let e = word.substring(i+1)

                for (let j=0; j<letters.length; j++) {
                    let newWord = f + letters[j] + e

                    if (eq.includes(newWord)) {
                        return count + 1
                    }

                    if (set.has(newWord)) {
                        sq.push(newWord)
                        set.delete(newWord)
                    }
                }
            }
        }

        count++
        
    }

    return 0
};
```

启发式搜索

```js
function AstarSearch(graph, start, end) {

  // 优先队列
  let pq = collections.priority_queue() # 优先级 —> 估价函数
  let visited = new Set()
  pq.push(start)
  visited.add(start)

  while(pq.size !== 0) {
    let node = pq.shift() // 出队列时，是经过评估的最优元素
    visited.add(node)

    // 处理
    process(node)

    nodes = generate_related_nodes(node)

    // 未被访问的 node. 这段是 python 代码
    unvisited = [node for node in nodes if node not in visited]

    pq.push(unvisited)
  }
}
```

https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/

```js
/**
 * @param {number[][]} grid
 * @return {number}
 */

// BFS 超时了 伤心,
var shortestPathBinaryMatrix = function(grid) {
  let len = grid.length;

  if (grid[0][0] === 1 || grid[len - 1][len - 1] === 1) return -1;

  let visited = new Set();
  visited.add(`00`);

  let q = [{ row: 0, col: 0, visited }],
    min = Number.MAX_SAFE_INTEGER;

  let dx = [0, 0, 1, -1, 1, -1, 1, -1];
  let dy = [1, -1, 0, 0, -1, 1, 1, -1];

  while (q.length !== 0) {
    let size = q.length;

    for (let k = 0; k < size; k++) {
      // 可以走八个方向
      let { row, col, visited } = q.shift();

      if (
        row === len - 1 &&
        col === len - 1 &&
        visited.has(`${len - 1}${len - 1}`)
      ) {
        min = Math.min(min, visited.size);
      }

      for (let i = 0; i < 8; i++) {
        let mark = `${row + dx[i]}${col + dy[i]}`;
        if (
          row + dx[i] < len &&
          row + dx[i] >= 0 &&
          col + dy[i] < len &&
          col + dy[i] >= 0 &&
          grid[row + dx[i]][col + dy[i]] === 0 &&
          !visited.has(mark)
        ) {
          visited.add(mark);
          q.push({
            row: row + dx[i],
            col: col + dy[i],
            visited: new Set(visited)
          });
          visited.delete(mark);
        }
      }
    }
  }

  return min === Number.MAX_SAFE_INTEGER ? -1 : min;
};
```

双向 BFS 依然超时

```js
/**
 * @param {number[][]} grid
 * @return {number}
 */

// 双向 BFS 

var find = (q, mark) => {
   return q.filter(i => i.row === mark.row && i.col === mark.col).length !== 0
}

var shortestPathBinaryMatrix = function(grid) {

    let len = grid.length
     
    // 起点是1 或终点是1 
    if (grid[0][0] === 1 || grid[len-1][len-1]) return -1
    if (len === 1 && grid[0][0] === 0) return 1
     
    let visited = new Set()
    
    let sq = [{row:0, col:0}], eq = [{row:len-1, col:len-1}], count = 1
    
    let dx = [0,0,1,-1,1,-1,1,-1]
    let dy = [1,-1,0,0,-1,1,1,-1]

    while (sq.length !== 0) {

        if (sq.length > eq.length) {
            [sq, eq] = [eq, sq]
        }

        let size = sq.length
        
        for(let k=0; k<size; k++) {
            // 可以走八个方向
            let {row, col} = sq.shift()

            for(let i=0; i<8; i++) {
                let mark = `${row+dx[i]}${col+dy[i]}`
                if (row+dx[i] < len && row+dx[i] >= 0 && 
                col+dy[i] < len && col+dy[i] >= 0 && 
                grid[row+dx[i]][col+dy[i]] === 0 && !visited.has(mark)) {

                    if (find(eq, {row: row+dx[i], col: col+dy[i]})) {
                        return count + 1
                    }

                    visited.add(mark)
                    sq.push({row: row+dx[i], col: col+dy[i]})
                    visited.delete(mark)
                }
            }
        }

        count++
    }

    return -1
};
```

https://leetcode-cn.com/problems/sliding-puzzle/

https://leetcode-cn.com/problems/sudoku-solver/
