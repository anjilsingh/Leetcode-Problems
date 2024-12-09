class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //we have to group anagrams 
        //what is anagram 
        //either sort or use a hashtable we kno it very well:)
        
        //can use a hashmap and put the values based on that 
        
        HashMap<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
            char[] strchar=str.toCharArray();
            Arrays.sort(strchar);
            String key=new String(strchar);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(str);
        
        }
        
        return new ArrayList<>(mp.values());
        
    }
}