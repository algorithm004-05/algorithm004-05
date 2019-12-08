/**
 * @param {string[]} strs
 * @return {string[][]}
 */


// 遍历数组的每个字符串，
// 把每个字符串拆分为字母数组，
// 检查hashMap中是否有此字符串数组的key，如果有则添加进key对应的value中
// 如果没有，新增key并赋值value
var groupAnagrams = function (strs) {
    let hash = new Map()

    for (let i = 0; i < strs.length; i++) {
        let str = strs[i].split('').sort().join()
        if (hash.has(str)) {
            let temp = hash.get(str)
            temp.push(strs[i])
            hash.set(str, temp)
        } else {
            hash.set(str, [str[i]])
        }
    }

    return [...hash.values()]
};
