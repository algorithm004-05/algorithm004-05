/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let container = [];
    
    function helper(open, close, current){
        if(open == 0 && close == 0){
            container.push(current);
            return;
        }
        if(open !== 0){
            helper(open-1, close, current+'(');
        }
        
        if(close !== 0 && close > open){
            helper(open, close -1, current+')');
        }
    }
    helper(n,n,'')
    return container
};