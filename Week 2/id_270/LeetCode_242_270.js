var isAnagram = function (s, t) {
  if(s.length !== t.length) return false
  var sMap = {}, tMap = {}
  for(var i = 0; i< s.length; i++) {
    if(!sMap[s[i]]) {
      sMap[s[i]] = 1
    } else {
      sMap[s[i]]++
    }
    if (!tMap[t[i]]) {
      tMap[t[i]] = 1
    } else {
      tMap[t[i]]++
    }
  }
  return compObj(sMap, tMap)
  
};

var compObj = function (a, b) {
  var keys = Object.keys(a)
  if(keys.length !== keys.length) return false
  for(var i = 0; i < keys.length; i++) {
    if(a[keys[i]] !== b[keys[i]]) return false
  }
  return true
}

console.log(isAnagram("anagramk", "knagaram"))