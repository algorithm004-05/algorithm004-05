/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let myArray = []
    for(let i of matrix){
        myArray = [...myArray,...i]
    }
    if(myArray.length === 1) return myArray[0] === target? true:false
    if(myArray.length === 0) return false
    let left = 0,
        right = myArray.length -1,
        mid = 0
    while(left <= right){
        mid = Math.round(left + (right-left)/2)
        if(myArray[mid] === target) return true
        else if(myArray[mid] < target) left = mid+1
        else right = mid -1
    }
    
    return false
};