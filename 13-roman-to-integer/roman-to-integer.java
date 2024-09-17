class Solution {
    public int romanToInt(String s) {
      Map<Character,Integer>mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        char[] str=s.toCharArray();
        int ans=0;
        for(int i=0;i<str.length;i++){
          if(i<str.length-1 && mp.get(str[i])<mp.get(str[i+1])){

            ans=ans-mp.get(str[i]);
          }
            else{
               ans=ans+mp.get(str[i]);
            }
        }
       return ans; 
    }
}