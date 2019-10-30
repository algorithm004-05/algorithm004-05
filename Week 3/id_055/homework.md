## 第 9 课

https://leetcode-cn.com/problems/word-ladder/description/

解法 1 BFS

```js
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  let changes = 'abcdefghigklmnopqrstuvwxyz';
  let wordListSet = new Set(wordList);

  if (!wordListSet.has(endWord)) {
    return 0;
  }

  // 注意求转换序列的长度，而不是变换次数，所以从 1 开始
  let queue = [{ word: beginWord, count: 1 }];

  while (queue.length !== 0) {
    let node = queue.shift();
    let word = node.word;

    // 匹配成功
    if (word === endWord) {
      return node.count;
    }

    for (let i = 0; i < word.length; i++) {
      for (let j = 0; j < changes.length; j++) {
        let arr = word.split('');

        arr[i] = changes[j];

        let newWord = arr.join('');

        if (wordListSet.has(newWord)) {
          queue.push({ word: newWord, count: node.count + 1 });
          wordListSet.delete(newWord);
        }
      }
    }
  }

  return 0;
};
```

https://leetcode-cn.com/problems/word-ladder-ii/description/

解法: 超时了, 有没有更好的方式

```js
var findLadders = function(beginWord, endWord, wordList) {
  let min = null;
  let visited = new Array(wordList.length).fill(false);

  if (wordList.indexOf(endWord) === -1) {
    return [];
  }

  // 注意求转换序列
  let queue = [{ word: beginWord, q: [beginWord], visited: visited }],
    res = [];

  while (queue.length !== 0) {
    let node = queue.shift();
    let word = node.word;
    let visited = node.visited;

    // 匹配成功
    if (word === endWord) {
      if (!min) min = node.q.length;
      if (min === node.q.length) {
        res.push(node.q);
      }
    }

    for (let i = 0; i < word.length; i++) {
      let indexes = findWordIndex(word, wordList, i);

      for (let j = 0; j < indexes.length; j++) {
        if (!visited[indexes[j]]) {
          visited[indexes[j]] = true;
          queue.push({
            word: wordList[indexes[j]],
            q: [...node.q, wordList[indexes[j]]],
            visited: [...visited]
          });
          visited[indexes[j]] = false;
        }
      }
    }
  }

  return res;
};

function findWordIndex(word, wordList, i) {
  let res = [];

  let arr = word.split('');
  arr[i] = '*';
  let newWord = arr.join('');

  let newWordList = wordList.map(w => {
    let arr = w.split('');
    arr[i] = '*';
    return arr.join('');
  });

  newWordList.forEach((n, i) => {
    if (n === newWord) {
      res.push(i);
    }
  });

  return res;
}
```

https://leetcode-cn.com/problems/number-of-islands/

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

https://leetcode-cn.com/problems/minesweeper/description/
