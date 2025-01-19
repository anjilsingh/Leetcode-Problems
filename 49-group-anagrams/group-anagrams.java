class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        HashMap<String,ArrayList<String>>mp=new HashMap<>();
        for(String str:strs){
           char[] strChar=str.toCharArray();
            Arrays.sort(strChar);
             String key=Arrays.toString(strChar);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(str);
        }
        return new ArrayList<>(mp.values());

    }
}