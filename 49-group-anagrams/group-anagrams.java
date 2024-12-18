class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //first crate the res list of list of string
   
        HashMap<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
            char strchar[]=str.toCharArray();
            Arrays.sort(strchar);
            String sortedStr=new String(strchar);
            mp.putIfAbsent(sortedStr,new ArrayList<>());
            mp.get(sortedStr).add(str);
        }
      return new ArrayList<>(mp.values());
    }
}