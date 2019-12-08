// 49. 字母异位词分组

// 哈希
var groupAnagrams = function(strs) {
    let arr = []
    let dct = {}
    for (let i in strs) {
        let tmp = strs[i].split('').sort().join('')
        tmp in dct ? dct[ tmp ].push(strs[i]) : dct[ tmp ] = [strs[i]]
    }
    for (let i in dct) {
        arr.push(dct[i])
    }
    return arr
};

