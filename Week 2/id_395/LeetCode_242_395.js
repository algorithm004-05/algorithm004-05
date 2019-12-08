/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    if (s.length != t.length) {
        return false
    }
    //1、暴力求解，直接排序字符串，比较是否相等
    // let ss = s.split("").sort().join("")
    // let st = t.split("").sort().join("")
    // return ss === st

    //2、通过hashmap统计字符的出现次数
    let map = {}
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i)
        map[c] = map[c] ? map[c] + 1 : 1
    }

    for (let i = 0; i < t.length; i++) {
        let c = t.charAt(i)
        if (!map[c]) {
            return false
        }
        map[c] = map[c] - 1
        if (map[c] < 0) {
            return false
        }
    }

    for (let key in map) {
        if (map[key] != 0) {
            return false
        }
    }
    return true
};
