class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int n= temperatures.length;
      int[] output=new int[n];
      Stack<int[]>st=new Stack<>();

      for(int i=0;i<n;i++){
        while(!st.isEmpty() && st.peek()[1]<temperatures[i]){
            int[] node=st.pop();
            int index=node[0];
            output[index]=i-index;
        }
        st.push(new int[]{i,temperatures[i]});
      }

      return output;
    }
}