class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        //bruteforce can be generrate all substrings of s2,sort this and also sort s1 and then just compare :)
        
        //if s1 length is greater then s2 directly return false 
        
        if(s1.length()>s2.length()) return false;
        if(s1.equals(s2)) return true;
        
        char[] s1char=s1.toCharArray();
        Arrays.sort(s1char);
        String sorteds1=new String(s1char);

           
        //generate all substrings and compare 
                                   
        for(int i=0;i<s2.length();i++){
            for(int j=i;j<s2.length();j++){
                
                if((j-i+1)==s1.length()){
                    char[] s2subchar=s2.substring(i,j+1).toCharArray();
                    Arrays.sort(s2subchar);
                    String sorted=new String(s2subchar);
                    if(sorted.equals(sorteds1)) return true;
                }
            }

        }
                                   return false;
    }
}