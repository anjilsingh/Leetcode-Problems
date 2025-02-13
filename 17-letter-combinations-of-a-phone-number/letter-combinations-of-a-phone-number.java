class Solution {
       HashMap<Character,String>mp=new HashMap<>();
        {
            mp.put('2',"abc");
            mp.put('3',"def");
            mp.put('4',"ghi");
            mp.put('5',"jkl");
            mp.put('6',"mno");
            mp.put('7',"pqrs");
            mp.put('8',"tuv");
            mp.put('9',"wxyz");

        }

        public void solve(StringBuilder sb,String digits,int index,List<String>res){
            if(index>=digits.length()){
                res.add(sb.toString());
                return;
            }

            String word=mp.get(digits.charAt(index));

            for(int i=0;i<word.length();i++){
                sb.append(word.charAt(i));
                solve(sb,digits,index+1,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    public List<String> letterCombinations(String digits) {
     List<String>res=new ArrayList<>();
     if(digits.length()==0){
        return res;
     }
     StringBuilder sb=new StringBuilder();
     solve(sb,digits,0,res);
     return res;

    }
}