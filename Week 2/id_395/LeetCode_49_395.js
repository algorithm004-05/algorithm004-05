/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    //1、暴力解法， 遍历所有字符串，排序后作为hashmap的key，做分组; 时间复杂度O(n*klogk)
    // let map = {}
    // for (let i = 0; i < strs.length; i++ ) {
    //     let s = strs[i]
    //     let key = s.split("").sort().join("")
    //     if(!map[key]) {
    //         map[key] = [s]
    //     } else {
    //         map[key].push(s)
    //     }
    // }
    //2、在暴力法的基础上，去掉字符串，将时间复杂度降O(n*k)
    let map = {}
    for (let i = 0; i < strs.length; i++) {
        let s = strs[i]
        let k = new Array(26).fill(0)
        for (let j = 0; j < s.length; j++) {
            k[s.charCodeAt(j) - 97]++
        }
        let key = k.join("")
        if (!map[key]) {
            map[key] = [s]
        } else {
            map[key].push(s)
        }
    }

    let ret = new Array()
    for (let k in map) {
        ret.push(map[k])
    }
    return ret
};
