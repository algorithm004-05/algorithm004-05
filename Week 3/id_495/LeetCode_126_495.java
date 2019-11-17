import java.util.*;


class LeetCode_126_495 {

    private static List<List<String>> res = new ArrayList<>();//结果
    private static Map<String, List<String>> map = new HashMap<>();//key为字符，value为其临近点的list，单一方向的（只会保存bfs时start向end前进所产生的记录）

    public static void main(String[] args) {
        System.out.println(findLadders("hit","cog",Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"})));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null) return res;
        Set<String> dicSet = new HashSet<>(wordList);
        if(!dicSet.contains(endWord)) return res;
        if(dicSet.contains(beginWord)) dicSet.remove(beginWord);
        Set<String> endSet = new HashSet<>(),beginSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        boolean finish=false;
        boolean reverse=false;//双端bfs，false表示从头，true表示从尾

        //非递归bfs
        while(!beginSet.isEmpty()){
            dicSet.removeAll(beginSet);//标记走过
            Set<String> tmpSet=new HashSet<>();
            for(String str:beginSet){
                char[] cArr=str.toCharArray();
                for(int i=0;i<cArr.length;i++){
                    char cTmp=cArr[i];//变化
                    for(char c='a';c<='z';c++){
                        if(c==cTmp) continue;
                        cArr[i]=c;
                        String newStr=new String(cArr);
                        if(!dicSet.contains(newStr)) continue;

                        if(endSet.contains(newStr)){
                            finish=true;
                        }else{
                            tmpSet.add(newStr);
                        }
                        String key = reverse? newStr:str;
                        String value = reverse ? str : newStr;
                        if(!map.containsKey(key)){
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(value);
                    }
                    cArr[i]=cTmp;//复原
                }
            }
            if(tmpSet.size()<=endSet.size()){
                beginSet=tmpSet;
            }else{
                reverse=!reverse;//来回反转
                beginSet=endSet;
                endSet=tmpSet;
            }
            if(finish) break;
        }

        //dfs的前进路线保存list
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        dfs(subList,beginWord,endWord);
        return res;
    }

    //简单dfs，因为是以此进行，所以不用辅助标记
    private static void dfs (List<String> subList,String beginWord,String endWord) {
        if(beginWord.equals(endWord)) {
          res.add(new ArrayList<>(subList));
          return;
        }
        if (!map.containsKey(beginWord)) {
          return;
        }
        for (String word : map.get(beginWord)) {
          subList.add(word);
          dfs(subList,word,endWord);
          subList.remove(subList.size() - 1);
        }
    }

}
