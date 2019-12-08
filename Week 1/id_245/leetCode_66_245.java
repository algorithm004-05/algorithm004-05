public static int[] plusOne(int[] digits) {
        for(int x =digits.length-1; x>=0; x--){
            if(digits[x] != 9){
                digits[x] +=1;
                return digits;
            }
            else{
                if(x == 0){
                    int [] newDigits = new int[digits.length+1];
                    newDigits[0] = 1;
                    return newDigits;
                }
                digits[x] = 0;
            }
        }
        return null;
    }
