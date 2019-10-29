/*
 *
 * [155] 最小栈
 */

/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.minArr = [];
  this.arr = []
};

/** 
* @param {number} x
* @return {void}
*/
MinStack.prototype.push = function(x) {
  this.arr.push(x)
  if(this.minArr.length){
      this.minArr[this.minArr.length-1] >= x ? this.minArr.push(x) : '' 
  }else{
      this.minArr.push(x)
  }
};

/**
* @return {void}
*/
MinStack.prototype.pop = function() {
  let item = this.arr.pop()
  if(this.minArr[this.minArr.length-1] === item) this.minArr.pop()
  return item
};

/**
* @return {number}
*/
MinStack.prototype.top = function() {
  return this.arr[this.arr.length -1 ]
};

/**
* @return {number}
*/
MinStack.prototype.getMin = function() {
  return this.minArr[this.minArr.length - 1]
};

/** 
* Your MinStack object will be instantiated and called as such:
* var obj = new MinStack()
* obj.push(x)
* obj.pop()
* var param_3 = obj.top()
* var param_4 = obj.getMin()
*/

/**
 * 耗时：116ms 击败97.48%
 * 内存：43.4mb
 * 时间复杂度O（1） 空间复杂度O（n）
 */
// ------------------------------------------