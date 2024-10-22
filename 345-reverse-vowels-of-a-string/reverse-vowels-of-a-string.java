class Solution {
    public void swap(char[] arr, int left, int right){
             char temp=arr[left];
             arr[left]=arr[right];
        arr[right]=temp;
             
    }
    public String reverseVowels(String s) {
        char[] charArr=s.toCharArray();
        int left=0;
        int right=charArr.length-1;
        
       Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        while(left<right){
            if(vowel.contains(charArr[left]) && vowel.contains(charArr[right])){
               swap(charArr,left,right);
                left++;
                right--;
            }
               
             else if(!vowel.contains(charArr[left])){
                  left++;
             }
              
               else{
                    right--;
               }
        
        }
               return new String(charArr);
}
}