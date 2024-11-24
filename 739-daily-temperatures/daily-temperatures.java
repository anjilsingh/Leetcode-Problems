class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Stack<int[]>st=new Stack<>();
        
        for(int i=0;i<n;i++){
          int currValue=temperatures[i];
          while(!st.isEmpty() && currValue>st.peek()[0]){

            int index=st.pop()[1];
            ans[index]=i-index;
          }
            st.push(new int[]{currValue,i});
        
        }
        return ans;
    }
}