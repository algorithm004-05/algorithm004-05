/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let sObj = countKey(s)
    let tObj = countKey(t)
    return isSameCount(sObj,tObj)

    function countKey(str){
        let obj = {}
        for(let item of str){
            if(obj[item]){  //直接使用隐士判断，注意考虑值为0/undefined/null的情况
                obj[item]++
            }else{
                obj[item] = 1
            }
        }
        return obj
    }

    function isSameCount(obj1,obj2){
        let flag = true;
        let keys = Object.keys(obj1).length > Object.keys(obj2).length ? Object.keys(obj1) : Object.keys(obj2)
        keys.forEach(key=>{
            if(obj1[key] !== obj2[key]){
                flag = false;
            }
        })
        return flag;
    }
};