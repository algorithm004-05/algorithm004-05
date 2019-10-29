/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
    //这个是我做棋牌时，配牌组合经常用的方法
    let order = []
    for (let i = 0; i <= k; i++) {
        order[i] = i
    }

    let ret = []
    while (order[0] == 0) {
        let ary = []
        for (let i = 1; i <= k; i++) {
            ary.push(order[i])
        }
        ret.push(ary)

        let flag = false
        let m = k
        while (!flag && m >= 0 && m <= k) {
            order[m]++
            if (order[m] > n) {
                order[m] = 1
                m = m - 1
            } else if (m < k) {
                m = m + 1
                order[m] = order[m - 1]
            } else if (m == k) {
                flag = true
            }
        }
    }
    return ret
};
