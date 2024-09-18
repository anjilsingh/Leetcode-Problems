class Solution {
    public String reverseVowels(String s) {
        int l=0;
        int r = s.length()-1;
        char arr[]=s.toCharArray();
        while(l<r){
            if((arr[l]== 'a'||arr[l]== 'e'|| arr[l]=='i'||arr[l]== 'o' ||arr[l]=='u' ||arr[l]=='A' ||arr[l]=='E'||arr[l]=='I'||arr[l]=='O'||arr[l]=='U') && (arr[r]== 'a'||arr[r]== 'e'|| arr[r]=='i'||arr[r]== 'o' ||arr[r]=='u' ||arr[r]=='A' ||arr[r]=='E'||arr[r]=='I'||arr[r]=='O'||arr[r]=='U')){
                char temp = arr[l];
                arr[l]= arr[r] ;
                arr[r]=temp;
                l++;
                r--;
            }
            else if((arr[l]== 'a'||arr[l]== 'e'|| arr[l]=='i'||arr[l]== 'o' ||arr[l]=='u' ||arr[l]=='A' ||arr[l]=='E'||arr[l]=='I'||arr[l]=='O'||arr[l]=='U') && (arr[r]!= 'a'||arr[r]!= 'e'|| arr[r]!='i'||arr[r]!= 'o' ||arr[r]!='u' ||arr[r]!='A' ||arr[r]!='E'||arr[r]!='I'||arr[r]!='O'||arr[r]!='U')){
                r--;
            }
            else{
                l++;
            }
            
        }
        return new String(arr);
        
    }
}