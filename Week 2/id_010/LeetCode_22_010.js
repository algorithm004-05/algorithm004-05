/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var results = []

    var _generateResults = function (left,right,max,s) {
    //temitate
    if(left === max && right ===max){
        results.push(s)
        return 
    }
        
    //process + recursion
    if(left<max){
        _generateResults(left+1,right,max,s+"(")
    }
    if(right<left){
        _generateResults(left,right+1,max,s+")")
    }
        
        
    //deal unuseelss
}
    
    _generateResults(0,0,n,'')
    
    
    return results
};

