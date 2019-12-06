/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    // 创建二维数组
    let memo = Array.from(new Array(word1.length + 1), () => new Array(word2.length + 1))
    for (let i = 0; i <= word1.length; i++) {
        for (let j = 0; j <= word2.length; j++) {
            // 初始化数组
            if (i === 0) {
                memo[i][j] = j;
            // 初始化数组
            } else if (j === 0) {
                memo[i][j] = i;
            // 字母相同则不+1
            } else if (word1[i - 1] === word2[j - 1]) {
                memo[i][j] = memo[i-1][j-1];
            } else {
                // 不同则选择最短路径再+1
                memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1], memo[i-1][j - 1]) + 1;
            }
        }
    }
    return memo[word1.length][word2.length]
};

//     r,o,s
//   0,1,2,3
// h,1,1,2,3
// o,2,2,1,2
// r,3,2,2,2
// s,4,3,3,2
// e,5,4,4,3