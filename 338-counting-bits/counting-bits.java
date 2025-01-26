class Solution {
    public int[] countBits(int n) {
        //no of one in binary representaion on n
        int[] arr=new int[n+1];

        for(int number=0;number<=n;number++){
            int res=0;
            int temp=number;
            while(temp>0){
                if((temp &1)==1){
                  res++;
                }
                temp=temp>>1;
            }
            arr[number]=res;
        }
        return arr;
    }
}