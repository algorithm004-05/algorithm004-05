var longestValidParentheses = function (s) {
  var max = 0, stack = [-1], len = s.length;
  for (var i = 0; i < len; i++) {
    if (s[i] === '(') {
      stack.push(i);
    } else {
      stack.pop();
      if (stack.length === 0) {
        stack.push(i);
      } else {
        max = Math.max(max, i - stack[stack.length - 1]);
      }
    }
  }
  return max;
};