class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
           HashMap<String,List<String>>mp=new HashMap<>();
           for(String str:strs){
                  char stChar[]=str.toCharArray();
                  Arrays.sort(stChar);
                  String key=new String(stChar);
                  
                  mp.putIfAbsent(key,new ArrayList<>());
                  mp.get(key).add(str);
            }

        return new ArrayList<>(mp.values());
    }
}