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
    public void solve(List<String>res,String digits,int index,StringBuilder sb){
        if(index>=digits.length()){
            res.add(sb.toString());
            return;
        }
        String word=mp.get(digits.charAt(index));
        for(int i=0;i<word.length();i++){
            sb.append(word.charAt(i));
            solve(res,digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        if(digits.length()==0) return res;
        solve(res,digits,0,sb);
        return res;
    }
}