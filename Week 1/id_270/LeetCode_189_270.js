// var rotate = function (nums, k) {
//   let len = nums.length
//   nums =  [...nums.slice(len - k, len), ...nums.slice(0, len - k)]
//   console.log(nums)
// };

var rotate = function (nums, k) {
  for(var i = 0; i < k; i++) {
    let pop = nums.pop()
    nums.unshift(pop)
  }
};

