class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]>st=new Stack<>();
        int[] output=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && st.peek()[1]<temperatures[i]){
                int[] ele=st.pop();
                int index=ele[0];
              
                output[index]=i-index;
            }
            st.push(new int[]{i,temperatures[i]});
        }

        return output;
    }
}