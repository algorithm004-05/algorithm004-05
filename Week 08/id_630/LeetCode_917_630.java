class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        for(int i=0; i<S.length(); i++) {
            Character c = S.charAt(i);
            if(Character.isLetter(c)){
                stack.push(c);
            }
        }
        for(Character c: S.toCharArray()) {
            if(Character.isLetter(c)){
                sb.append(stack.pop());
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}