class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>>mp=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] strchar=str.toCharArray();
            Arrays.sort(strchar);
            String key=Arrays.toString(strchar);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(strs[i]);

        }

        return new ArrayList<>(mp.values());
    }
}