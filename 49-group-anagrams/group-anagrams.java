class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String,List<String>>mp=new HashMap<>();
     for(String str:strs) {
         //sort this string 
         char[] strchar=str.toCharArray();
         Arrays.sort(strchar);
         String key=new String(strchar);
         mp.putIfAbsent(key,new ArrayList<>());
         mp.get(key).add(str);
     }
        return new ArrayList<>(mp.values());
    }
}