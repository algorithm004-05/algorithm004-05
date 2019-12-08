/**
 * @param {string} digits
 * @return {string[]}
 */


var letterCombinations = function(digits) {
    if (digits.length === 0) return []
    let results = [],
        len = digits.length,
        myMap = new Map()
    myMap.set('2','abc')
    myMap.set('3','def')
    myMap.set('4','ghi')
    myMap.set('5','jkl')
    myMap.set('6','mno')
    myMap.set('7','pqrs')
    myMap.set('8','tuv')
    myMap.set('9','wxyz')
    let count = 0
    var _letterCombinations = function (step,s){
        if(step === len){
            results.push(s)
            return 
        }
        let myArray = digits.split('')
        // for(var i = step; i<3; ++i){
            let myMapArr = myMap.get(myArray[step]).split('')
            for(j of myMapArr){
                _letterCombinations(step+1,s+j)
             }
        // }

    }
    _letterCombinations(0,'')
    return results
};