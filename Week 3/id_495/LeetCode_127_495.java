import java.util.*;

class LeetCode_127_495 {
    """
    
    """

    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog",Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"})));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        int step=1;
        if (!dic.contains(endWord)) return 0;
        while(!start.isEmpty()){
            step++;
            HashSet<String> tmpSet=new HashSet<>();
            dic.removeAll(start);
            for(String s:start){
                char[] arr=s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char tmp=arr[i];
                    for(char c='a';c<='z';c++){
                        if(tmp==c) continue;
                        arr[i]=c;
                        String strTmp=new String(arr);
                        if(dic.contains(strTmp)){
                            if(end.contains(strTmp)){
                                return step;
                            }else{
                                tmpSet.add(strTmp);
                            }
                        }
                    }
                    arr[i]=tmp;
                }
            }
            if(tmpSet.size()<end.size()){
                start=tmpSet;
            }else{
                start=end;
                end=tmpSet;
            }

        }
        return 0;
    }

}
