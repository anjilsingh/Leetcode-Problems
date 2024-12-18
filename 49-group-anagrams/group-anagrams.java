class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //first crate the res list of list of string
    //or instead of sorting we can use a hashtable 
        
        HashMap<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
          int[] arr=new int[26];
          for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']++;
          }
          
           String keyStr=Arrays.toString(arr);
          mp.putIfAbsent(keyStr,new ArrayList<>());
         mp.get(keyStr).add(str);
        }
      return new ArrayList<>(mp.values());
    }
}