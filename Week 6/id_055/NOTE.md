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
