
let groupAnagrams = function (strs) {
  let res = [[strs[0]]]
  let strLen = strs.length
  for (let i = 1; i < strLen; i++) {
    let resLen = res.length;
    var found = false
    for (let j = 0; j < resLen; j++) {
      if (isAnagram(strs[i], res[j][0]) ) {
        res[j].push(strs[i])
        found = true
        break
      }
    }
    if (!found) {
      res[res.length] = [strs[i]]
    }
  }
  return res
};

let isAnagram = function (s, t) {
  if (s.length !== t.length) return false
  let sMap = {}, tMap = {}
  for (let i = 0; i < s.length; i++) {
    if (!sMap[s[i]]) {
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

let compObj = function (a, b) {
  let keys = Object.keys(a)
  if (keys.length !== keys.length) return false
  for (let i = 0; i < keys.length; i++) {
    if (a[keys[i]] !== b[keys[i]]) return false
  }
  return true
}

