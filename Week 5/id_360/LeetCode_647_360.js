/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function (s) {
    let dp = Array.from(new Array(s.length), () => new Array(s.length).fill(0));
    for (let i = s.length - 1; i >= 0; i--) {
        for (let j = i; j < s.length; j++) {
            // 同一个字符时
            if (j == i) {
                dp[i][j] = true
            };
            // 两个及两个以上字符时
            if (s[i] == s[j]) {
                if (i + 1 == j) {
                    // 如果是两个字符
                    dp[i][j] = true;
                } else if (i < s.length - 1 && dp[i + 1][j - 1]) {
                    // 如果更小的回文存在
                    dp[i][j] = true;
                }
            }
        }
    }
    let count = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        for (let j = i; j < s.length; j++) {
            if (dp[i][j]) count++;
        }
    }
    return count;
};

//      a       b       c       d       c       e    
// a    true    0       0       0       0       0    
// b            true    0       0       0       0    
// c                    true    0       true    0    
// d                            true    0       0    
// c                                    true    0    
// e                                           true