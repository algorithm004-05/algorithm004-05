class Solution{
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill:bills){
            if(bill == 5){
                //收到5元 直接+
                five++;
            }else if (bill == 10){
                //收到10元 有5元找零 没有false
                if (five>0){
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else  if (bill == 20){
                //收到20元 可以找10+5或者5*3
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if (five >=3){
                    five -=3;
                }else{
                    return  false;
                }
            }
        }
        return  true;
    }
}