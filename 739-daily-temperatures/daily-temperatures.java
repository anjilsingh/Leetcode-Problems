class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Stack<int[]>st=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
          while(!st.isEmpty() && st.peek()[1]<temperatures[i]){
             int index=st.pop()[0];
             ans[index]=i-index;
          }
            st.push(new int[]{i,temperatures[i]});
        }
        return ans;
    }
}