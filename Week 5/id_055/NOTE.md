# NOTE

https://leetcode-cn.com/problems/fibonacci-number/

```js
/**
 * @param {number} N
 * @return {number}
 */
/* 傻递归 2^n */
// var fib = function(N) {
//     if (N <= 1) {
//         return N
//     }
//     return fib(N-1) + fib(N-2)
// };

/* 记忆搜索 */
// let memory = []

// var fib = function(N) {
//     if (N <= 1) {
//         return N
//     }

//     if (memory[N] === undefined) {
//         memory[N] = fib(N-1) + fib(N-2)
//     }

//     return memory[N]
// };

/* 自底向上 */
var fib = function(N) {
  if (N <= 1) {
    return N;
  }

  let f0 = 0,
    f1 = 1,
    f2;

  for (let i = 2; i <= N; i++) {
    f2 = f0 + f1;
    f0 = f1;
    f1 = f2;
  }

  return f2;
};
```

https://leetcode-cn.com/problems/unique-paths-ii/submissions/

解法 1

```js
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
/*
傻递归
*/
var uniquePathsWithObstacles = function(obstacleGrid) {
  if (!obstacleGrid) return 0;

  let rows = obstacleGrid.length;
  let cols = obstacleGrid[0].length;

  function helper(obstacleGrid, row, col) {
    if (row === 0 && col === 0 && obstacleGrid[row][col] !== 1) {
      return 1;
    }

    if (row < 0 || col < 0 || obstacleGrid[row][col] === 1) {
      return 0;
    }

    return (
      helper(obstacleGrid, row - 1, col) + helper(obstacleGrid, row, col - 1)
    );
  }

  return helper(obstacleGrid, rows - 1, cols - 1);
};
```

解法 2

```js
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
  if (!obstacleGrid) return 0;

  let rows = obstacleGrid.length;
  let cols = obstacleGrid[0].length;

  let matrix = Array.from(Array(rows), () => new Array(cols).fill(null));

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (obstacleGrid[i][j] === 1) {
        // 障碍物
        matrix[i][j] = 0;
      } else {
        if (i === 0 && j === 0) {
          // start
          matrix[i][j] = 1;
        } else if (i === 0 && j !== 0) {
          // 左边界
          matrix[i][j] = matrix[i][j - 1];
        } else if (j === 0 && i !== 0) {
          // 上边界
          matrix[i][j] = matrix[i - 1][j];
        } else {
          matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        }
      }
    }
  }
  return matrix[rows - 1][cols - 1];
};
```

https://leetcode-cn.com/problems/triangle/

```js
/**
 * @param {number[][]} triangle
 * @return {number}
 */
// 傻递归
// var minimumTotal = function(triangle) {

//     let min = Number.MAX_SAFE_INTEGER
//     let level = triangle.length

//     function helper(level, path, row, col) {
//         // 递归终止条件
//         if (level === row) {
//             min = Math.min(path, min)
//             return
//         }
//         // 下探
//         helper(level, path + triangle[row][col] , row+1, col)
//         helper(level, path + triangle[row][col] , row+1, col+1)
//     }

//     helper(level, 0, 0, 0)

//     return min
// };

/**
 * 记忆化搜索
 */

var minimumTotal = function(triangle) {
  let level = triangle.length;
  let mem = Array.from(new Array(level), () => new Array(level).fill(null));

  function helper(max, row, col) {
    if (mem[row][col] !== null) {
      return mem[row][col];
    } else {
      // 递归终止条件
      if (max === row) {
        mem[row][col] = triangle[row][col];
        return mem[row][col];
      }

      // 下探
      let left = helper(max, row + 1, col);
      let right = helper(max, row + 1, col + 1);

      mem[row][col] = Math.min(left, right) + triangle[row][col];
      return mem[row][col];
    }
  }

  return helper(level - 1, 0, 0);
};

/*
状态方程 dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + a[i][j]
*/

var minimumTotal = function(triangle) {
  let level = triangle.length;

  let matrix = Array.from(new Array(level - 1), () => new Array(level).fill(0));

  // 最后一行不变
  matrix.push(triangle[level - 1]);

  // 从倒数第二行开始
  for (let row = level - 2; row >= 0; row--) {
    for (let col = triangle[row].length - 1; col >= 0; col--) {
      matrix[row][col] =
        Math.min(matrix[row + 1][col], matrix[row + 1][col + 1]) +
        triangle[row][col];
    }
  }

  return matrix[0][0];
};
```

https://leetcode-cn.com/problems/maximum-subarray/

```js
/**
 * @param {number[]} nums
 * @return {number}
 */
/**
 * 1.暴力 O(n^2)
 * 2.DP
 */
// var maxSubArray = function(nums) {

//     let sum = numbers => numbers.reduce((a,b) => a+b)

//     let max = Number.MIN_SAFE_INTEGER

//     for(let i=0; i<nums.length; i++) {
//         for(let j=i+1; j<=nums.length; j++) {
//             max = Math.max(sum(nums.slice(i,j)), max)
//         }
//     }

//     return max
// };

// var maxSubArray = function(nums) {
//     let sum = nums[0]
//     let max = sum

//     for (let i=1; i<nums.length; i++) {
//         // if(sum + nums[i] > nums[i])
//         if (sum > 0) {
//             sum += nums[i]
//         } else {
//             sum = nums[i]
//         }
//         max = Math.max(sum, max)
//     }

//     return max
// }

/**
 * f(n) = max(f(n-1)+a[n], a[n])
 * cache f[n]
 * dp[n] = max(dp[n-1]+a[n], a[n])
 */

var maxSubArray = function(nums) {
  let dp = [nums[0]];

  for (let i = 1; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
  }

  return Math.max(...dp);
};
```

https://leetcode-cn.com/problems/maximum-product-subarray/submissions/

```js
/**
 * @param {number[]} nums
 * @return {number}
 */

/**
 * 1.暴力
 * 2.dp
 */

var maxProduct = function(nums) {
  let min = (max = nums[0]),
    dp = [nums[0]];

  for (let i = 1; i < nums.length; i++) {
    if (nums[i] < 0) {
      [min, max] = [max, min];
    }
    max = Math.max(max * nums[i], nums[i]);
    min = Math.min(min * nums[i], nums[i]);

    dp[i] = max;
  }

  return Math.max(...dp);
};
```

https://leetcode-cn.com/problems/coin-change/submissions/

BFS

```js
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
/**
 * BFS 超时
 * BFS 加缓存 (记录已经访问的节点)
 */
var coinChange = function(coins, amount) {
  if (amount === 0) return 0;

  coins.sort((a, b) => b - a);

  let queue = [amount],
    step = 0,
    visited = new Set();

  while (queue.length !== 0) {
    let size = queue.length;

    for (let i = 0; i < size; i++) {
      let node = queue.shift();

      if (node === 0) {
        return step;
      }

      // 先从大额硬币开始
      for (let coin of coins) {
        // 优化点，已经访问过的节点，无需再访问，必须还可以继续兑换零钱
        if (node >= coin && !visited.has(node - coin)) {
          visited.add(node - coin);
          queue.push(node - coin);
        }
      }
    }

    step++;
  }

  return -1;
};
```

DP

```js
/**
 * DP f(n) = min(f(n-k)) + 1  k =[1,2,3]
 */
var coinChange = function(coins, amount) {
  // 最大组合不会超过 amount+1
  let max = amount + 1;

  let dp = new Array(amount + 1).fill(max);

  // amount 为 0 时，组合数为 0
  dp[0] = 0;

  for (let i = 1; i <= amount; i++) {
    for (let coin of coins) {
      if (i - coin >= 0) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
  }

  return dp[amount] === max ? -1 : dp[amount];
};
```
