/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let myMap = new Map()
    
    for(bill of bills){
        if(bill === 20){
            if((myMap.get(5)>=1) && (myMap.get(10)>=1)){
                myMap.set(5,myMap.get(5)-1)
                myMap.set(10,myMap.get(10)-1)
            }
            else if(myMap.get(5)>=3){
                myMap.set(5,myMap.get(5)-3)
            }else{
                return false
            }
        }
        else if(bill === 10){
            if(myMap.get(5)>=1){
                myMap.set(5,myMap.get(5)-1)
                myMap.set(10,(myMap.get(10)+1) || 1)
            }else{
                return false
            }
        }else{
            myMap.set(5,(myMap.get(5)+1) || 1)
        }
    }
    
    return true
};