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

https://leetcode-cn.com/problems/friend-circles
https://leetcode-cn.com/problems/number-of-islands/
https://leetcode-cn.com/problems/surrounded-regions/
