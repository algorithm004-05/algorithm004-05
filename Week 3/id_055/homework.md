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
https://leetcode-cn.com/problems/minesweeper/description/
