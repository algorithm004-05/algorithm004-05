/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const primeNum = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101]
    let myMap = new Map()
    for(str of strs){
        let results = 1
        for(var i =0; i< str.length;++i){
            results *= primeNum[str[i].charCodeAt(0)-97]
        }
        let l = myMap.get(results) || []
        l.push(str)
        myMap.set(results,l)
    }
    return Array.from(myMap.values())
};