class LeetCode_860_495 {

  public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[] {5,5,5,10,20}));
  }

  public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int b : bills){
            if(b == 5) five ++;
            else if(b == 10) {
                if(five-- == 0) return false;
                ten++;
            }else {
                if(five > 0 && ten > 0){
                    five--; ten--;
                }
                else if(five > 2){
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
