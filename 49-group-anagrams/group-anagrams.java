class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //we can use a hashmap for string the string and its corresponding list of string
        
        HashMap<String,List<String>>mp=new HashMap<>();
        
        for(String str:strs){
            char[] strChar=str.toCharArray();
            Arrays.sort(strChar);
            String key=new String(strChar);
            //put this sorted string in map if it is not present earlier
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(str);

        }
        return new ArrayList<>(mp.values());
    }
}