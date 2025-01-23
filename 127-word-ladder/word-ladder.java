class Pair{
    String w;
    int s;
    Pair(String w,int s){
        this.w=w;
        this.s=s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }

        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair pair=q.poll();
            String word=pair.w;
            int steps=pair.s;

            if(word.equals(endWord)){
                return steps;
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char wordarr[]=word.toCharArray();
                    wordarr[i]=ch;
                    String newW=new String(wordarr);

                    if(set.contains(newW)){
                        q.add(new Pair(newW,steps+1));
                        set.remove(newW);
                    }
                }
            }
        }

        return 0;
    }
}