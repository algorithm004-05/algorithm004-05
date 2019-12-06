/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
  if (bills[0] > 5) return false;
  
  var five = ten = 0;
  for (var i = 0; i < bills.length; i++) {
      if (bills[i] === 5) five++;
      
      if(five === 0) return false;
      if (bills[i] === 10) (ten++, five--);
      
      if (bills[i] === 20) {
          if (ten > 0) (ten--, five--);
          else if (five >= 3) five -= 3;
          else return false;
      }
  }
  return true;
};