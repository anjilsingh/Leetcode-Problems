class Solution {
    public String largestNumber(int[] nums) {
        //create a string to store values i forms of string
        String str[]=new String[nums.length];
        //store int values by converting in string format String.valueOf() method
        for(int i=0;i<nums.length;i++){
             str[i]=String.valueOf(nums[i]);
        }
        //custom sort the array based on lexicographically comparing a+b and b+a
        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));
        if(str[0].equals("0")){
           return "0";
        }
        //create a string builder 
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
        }
        
        return sb.toString();
        
    }
}