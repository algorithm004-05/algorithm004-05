/*
 *
 * [20] 有效的括号
 */

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  let map = {
      '[':']',
      '{':'}',
      '(':")",
  }
  let arr = []
  for(let i = 0;i<s.length;i++){
      if(s[i] in map){
          arr.push(map[s[i]])
      }else{
          if(s[i] !== arr.pop()){
           return false   
          }
      }
  }
  return !arr.length
};
/**
 * 耗时：60ms 击败96.87%
 * 内存：33.75mb
 * 时间复杂度O（n）
 */
// ------------------------------------------
var isValid = function(s) {
  while(s.length){
      let temp = s
      s = s.replace('()',"")
      s = s.replace('{}',"")
      s = s.replace('[]',"")
      if(s === temp) return false
  }
  return true
};
/**
 * 耗时：88ms 击败31.35%
 * 内存：35.75mb
 * 时间复杂度 不知
 */
// ------------------------------------------