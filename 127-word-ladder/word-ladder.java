class Solution {
    class Pair{
         String first;
         int sec;
        Pair(String first,int sec){
           this.first=first;
            this.sec=sec;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>();
        for(String word:wordList){
           set.add(word);
        }
        
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().sec;
            q.remove();
            if(word.equals(endWord)) return steps;
            
            for(int i=0;i<word.length();i++){
             for(char ch='a';ch<='z';ch++){
                 char[] charArr=word.toCharArray();
                 charArr[i]=ch;
                 String modString=new String(charArr);
                 
                 if(set.contains(modString)){
                    q.add(new Pair(modString,steps+1));
                     set.remove(modString);
                 }
             }
            
            }
            
        }
        return 0;
    }
}