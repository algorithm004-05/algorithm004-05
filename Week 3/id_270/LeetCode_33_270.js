/**
 * 
 * 渣渣代码！！！  慎阅
 * 
 *  几秒前	通过	104 ms	36.1 MB	Javascript
  6 分钟前	解答错误	N/A	N/A	Javascript
  1 小时前	解答错误	N/A	N/A	Javascript
  2 小时前	超出时间限制	N/A	N/A	Javascript
  2 小时前	解答错误	N/A	N/A	Javascript
  2 小时前	超出时间限制	N/A	N/A	Javascript
 */
var findMinIndex = function (nums) {
  let len = nums.length
  if (nums[0] <= nums[len - 1]) return 0
  if(len > 1) {
    if (nums[len - 1] < nums[len - 2]) return len - 1
  }

  var left = 0
  var right = nums.length - 1
  while (left < right) {
    console.log(left, right)
    var mid = parseInt((left + right) / 2)
    if (nums[mid] < nums[mid - 1]) return mid
    else {
      if(nums[mid] > nums[right]) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
  }
  return left
}


var search = function (nums, target) {
  var left, right
  if (target > nums[nums.length - 1] && target < nums[0]) return -1
  if (!nums.length) return -1
  if (target >= nums[0]) {
    left = 0
    right = findMinIndex(nums) ? findMinIndex(nums) - 1 : nums.length - 1
  } else {
    left = findMinIndex(nums)
    right = nums.length - 1
  }
  if (left === right) return nums[left] === target ? left : -1
  while (left <= right) {
    var mid = parseInt((left + right) / 2)
    if (nums[mid] > target) right = mid - 1
    else if (nums[mid] < target) left = mid + 1
    else return mid
  }
  return -1
};

// console.log(search([3,1], 1))
// console.log(findMinIndex([3, 1]))
// console.log(findMinIndex([1,3], 4))

