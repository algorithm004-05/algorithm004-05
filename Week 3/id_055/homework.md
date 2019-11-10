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

## 第 10 课

https://leetcode-cn.com/problems/lemonade-change/description/

```js
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
  let five = 0,
    ten = 0;

  for (let i = 0; i < bills.length; i++) {
    // 顾客支付 5 美元，直接收钱
    if (bills[i] === 5) {
      five++;
    } else if (bills[i] === 10) {
      // 顾客支付 10 美元，如果有 5 美元零钱，找钱，否则失败
      if (five > 0) {
        five--;
        ten++;
      } else {
        return false;
      }
    } else {
      // 顾客支付 20 美元，如果有 5 美元 和 10 美元零钱，找钱，
      if (ten > 0 && five > 0) {
        ten--;
        five--;
      } else if (five >= 3) {
        // 顾客支付 20 美元，如果只有 5 美元，找钱 3*5，否则失败
        five -= 3;
      } else {
        return false;
      }
    }
  }

  return true;
};
```

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/

```js
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let profit = 0;
  for (let i = 1; i < prices.length; i++) {
    if (prices[i] > prices[i - 1]) {
      profit += prices[i] - prices[i - 1];
    }
  }

  return profit;
};
```

https://leetcode-cn.com/problems/assign-cookies/description/

解法

```js
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);

  let i = 0,
    j = 0,
    res = 0;

  while (i < g.length && j < s.length) {
    // 当饼干可以满足胃口
    if (g[i] <= s[j]) {
      i++;
      j++;
      res++;
      // 不满足胃口，拿更大尺寸的饼干
    } else {
      j++;
    }
  }

  return res;
};
```

https://leetcode-cn.com/problems/walking-robot-simulation/description/

解法

```js
/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
  let dx = [0, 1, 0, -1];
  let dy = [1, 0, -1, 0];
  let x = 0,
    y = 0,
    di = 0;

  let set = new Set(obstacles.map(s => s.toString()));

  let ans = 0;

  for (let i = 0; i < commands.length; i++) {
    if (commands[i] === -2) {
      di = (di + 3) % 4;
    } else if (commands[i] === -1) {
      di = (di + 1) % 4;
    } else {
      for (let k = 0; k < commands[i]; k++) {
        let nx = x + dx[di];
        let ny = y + dy[di];
        let code = `${nx},${ny}`;

        if (!set.has(code)) {
          x = nx;
          y = ny;
          ans = Math.max(ans, x * x + y * y);
        }
      }
    }
  }

  return ans;
};
```

https://leetcode-cn.com/problems/jump-game/

```js
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
  let lastPos = nums.length - 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    if (i + nums[i] >= lastPos) {
      lastPos = i;
    }
  }
  return lastPos === 0;
};
```

https://leetcode-cn.com/problems/jump-game-ii/

// 不理解

```js
/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
  let end = 0,
    maxPosition = 0,
    steps = 0;

  for (let i = 0; i < nums.length - 1; i++) {
    maxPosition = Math.max(maxPosition, nums[i] + i);
    if (i === end) {
      //遇到边界，就更新边界，并且步数加一
      end = maxPosition;
      steps++;
    }
  }

  return steps;
};
```

### 第 11 课

https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

```js
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  let left = 0,
    right = nums.length - 1;
  while (left <= right) {
    let mid = Math.floor((right + left) / 2);

    if (nums[mid] === target) {
      return mid;
    } else if (nums[mid] < nums[right]) {
      // 说明右边有序
      if (nums[right] >= target && target > nums[mid]) {
        // 目标在有序的一边，将 left 紧逼
        left = mid + 1;
      } else {
        // 排除一半，进入另一半
        right = mid - 1;
      }
    } else {
      // 说明左边有序
      if (nums[left] <= target && target < nums[mid]) {
        // 目标在有序的一边，将 right 紧逼
        right = mid - 1;
      } else {
        // 排除一半，进入另一半
        left = mid + 1;
      }
    }
  }

  return -1;
};
```

https://leetcode-cn.com/problems/search-a-2d-matrix/

```js
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  let row = matrix.length;
  if (row === 0) return false;
  let column = matrix[0].length;

  let left = 0,
    right = row * column - 1;

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);

    // 坐标转换, 注意 行号等于  下标/列数, 列号 下标%列数
    let r = Math.floor(mid / column);
    let c = mid % column;

    if (matrix[r][c] === target) {
      return true;
    } else if (matrix[r][c] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return false;
};
```

https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

```js
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  let left = 0;
  (right = nums.length - 1), (min = Number.MAX_SAFE_INTEGER);

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);

    if (nums[mid] < nums[right]) {
      // 右边有序, 获取最小值
      min = Math.min(min, nums[mid]);
      // 修改范围，紧逼，搜索左边
      right = mid - 1;
    } else {
      // 左边有序, 获取最小值
      min = Math.min(min, nums[left]);
      // 修改范围，紧逼，搜索右边
      left = mid + 1;
    }
  }

  return min;
};
```
