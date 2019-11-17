import java.util.*;

class LeetCode_455_495 {

  public static void main(String[] args) {
      System.out.println(findContentChildren(new int[] {1,2},new int[] {1,2,3}));
  }

  public static int findContentChildren(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);
      int index_cookie = s.length-1, index_child = g.length-1;
      int count = 0;
      while(index_cookie >= 0 && index_child >= 0){
          if(s[index_cookie] >= g[index_child]){
              ++count;
              --index_cookie;
          }
          --index_child;
      }
      return count;
    }
}
