/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    var temp = [], len = heights.length
    var results = 0
    for(var i = 0;i<len; ++i){
        temp = []
        temp.push(heights[i])
        for(var j = i-1; j >= 0; --j){
            if(heights[j] < temp[0]) break
            else temp.push(heights[j])
        }
        for(var k = i+1; k<len; ++k){
            if(heights[k] < temp[0]) break
            else temp.push(heights[k])
        }
        if(temp[0] * temp.length > results) results = temp[0] * temp.length
    }
    return results
};