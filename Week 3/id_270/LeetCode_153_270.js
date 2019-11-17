var findMin = function (nums) {
  let len = nums.length
  if (nums[0] <= nums[len - 1]) return nums[0]
  if (len > 1) {
    if (nums[len - 1] < nums[len - 2]) return nums[len - 1]
  }

  
  var left = 0
  var right = nums.length - 1
  while (left < right) {
    console.log(left, right)
    var mid = parseInt((left + right) / 2)
    if (nums[mid] < nums[mid - 1]) return nums[mid]
    else {
      if (nums[mid] > nums[right]) {
        left = mid + 1
      } else { 
        right = mid - 1
      }
    }
  }
  
  return nums[left]
}