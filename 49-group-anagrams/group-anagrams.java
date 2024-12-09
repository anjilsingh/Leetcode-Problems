class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //we have to group anagrams 
        //what is anagram 
        //either sort or use a hashtable we kno it very well:)
        
        //can use a hashmap and put the values based on that 
        
        HashMap<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
            //or instead of sorting can use a hashtable 
            int count[]=new int[26];
             for(char c:str.toCharArray()){
                count[c-'a']++;
             }
            String key=Arrays.toString(count);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(str);
        
        }
        
        return new ArrayList<>(mp.values());
        
    }
}