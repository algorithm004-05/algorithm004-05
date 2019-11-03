/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// 暴力for循环
// var twoSum = function(nums, target) {
//     for (var i = 0; i < nums.length; i ++) {
//         for (var j = i + 1; j< nums.length; j ++){
//             if (nums[i] + nums[j] === target) {
//                 return [i,j]
//             }
//         }
//     }
//     return 
// };


// map是否可以取到值为target - num[i]的key，有则返回，没有则把nums[i]添加进key
// map底层实现为hash，所有hash的时间复杂度都是O(1)
var twoSum = function(nums, target) {
    let map = new Map()
    for (let i = 0; i < nums.length; i++) {
        let orderIndex = map.get(target - nums[i])
        if (orderIndex !== undefined) {
            return [orderIndex, i]
        }
        map.set(nums[i], i)
    }
}