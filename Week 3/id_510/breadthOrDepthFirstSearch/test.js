
function test() {
  var aa = {
    list1: [{ aa: 11, bb: 22 }, { aa: 33, bb: 44 }],
    list2: [{ aa: 111, bb: 222 }, { aa: 333, bb: 444 }]
  };
  for (var key in aa) {
    console.log(key);
    aa[key].forEach(function(value, index) {
      console.log(value.aa + "==" + index);
    });
  }
}
test();
