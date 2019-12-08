https://leetcode-cn.com/problems/longest-valid-parentheses/

```js
/**
 * @param {string} s
 * @return {number}
 */
// 1. 暴力法，找出所有组合，使用 stack 验证是否有效，找出最长的
// 2. DP
// 3. 左右指针

/*
2. DP 
s[n] === ')' and s[n-1] === '(' dp(n) = dp(n-2) + 2
s[n] === ')' and s[n-1] === ')' and s[i - dp[i - 1] - 1] === '(' dp(n) = dp(n-1) + dp(n-dp(n-1)-2) + 2 
*/
var longestValidParentheses = function(s) {
  if (!s) return 0;

  let dp = Array(s.length).fill(0);

  for (let i = 1; i < s.length; i++) {
    if (s[i] === ")") {
      if (s[i - 1] === "(") {
        dp[i] = dp[i - 2 > 0 ? i - 2 : 0] + 2;
      } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] === "(") {
        dp[i] =
          dp[i - 1] + dp[i - dp[i - 1] - 2 > 0 ? i - dp[i - 1] - 2 : 0] + 2;
      }
    }
  }

  return Math.max(...dp);
};
```

解法 2

```js
var longestValidParentheses = function(s) {
  let left = 0,
    right = 0,
    max = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === "(") {
      left++;
    } else {
      right++;
    }

    if (left === right) {
      max = Math.max(max, right * 2);
    } else if (right > left) {
      right = left = 0;
    }
  }

  left = right = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    if (s[i] === "(") {
      left++;
    } else {
      right++;
    }

    if (left === right) {
      max = Math.max(max, right * 2);
      // 注意倒序 是看左括号大于右括号，重置数目为 0
    } else if (left > right) {
      right = left = 0;
    }
  }

  return max;
};
```

https://leetcode-cn.com/problems/minimum-path-sum/

解法 DP

```js
/**
 * @param {number[][]} grid
 * @return {number}
 * dp[m][n] = Math.min(dp[m-1][n], dp[m][n-1]) + grid[m][n]
 */
var minPathSum = function(grid) {
  let rows = grid.length;
  let cols = grid[0].length;

  let dp = Array.from(new Array(rows), () => new Array(cols).fill(0));

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (i === 0 && j === 0) {
        dp[i][j] = grid[i][j];
      } else if (i !== 0 && j === 0) {
        dp[i][j] = dp[i - 1][j] + grid[i][j];
      } else if (i === 0 && j !== 0) {
        dp[i][j] = dp[i][j - 1] + grid[i][j];
      } else {
        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
      }
    }
  }

  return dp[rows - 1][cols - 1];
};
```

https://leetcode-cn.com/problems/edit-distance/ (?)
https://leetcode-cn.com/problems/decode-ways (?)
https://leetcode-cn.com/problems/maximal-square/

```js
/**
 * @param {character[][]} matrix
 * @return {number}
 */

// when matrix[m][n] === 1,  f(m, n) = min(f(m, n-1), f(m-1, n), f(m-1, n-1)) + 1
var maximalSquare = function(matrix) {
  let rows = matrix.length;
  if (rows === 0) return 0;
  let cols = matrix[0].length;

  let max = 0;
  let dp = Array.from(new Array(rows), () => new Array(cols).fill(0));

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (i === 0 || j === 0) {
        dp[i][j] = matrix[i][j];
      } else {
        if (matrix[i][j] === "1") {
          dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
        }
      }
      max = Math.max(max, dp[i][j]);
    }
  }

  return max * max;
};
```

https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
https://leetcode-cn.com/problems/frog-jump/
https://leetcode-cn.com/problems/split-array-largest-sum
https://leetcode-cn.com/problems/student-attendance-record-ii/
https://leetcode-cn.com/problems/task-scheduler/
https://leetcode-cn.com/problems/palindromic-substrings/
https://leetcode-cn.com/problems/minimum-window-substring/
https://leetcode-cn.com/problems/burst-balloons/
