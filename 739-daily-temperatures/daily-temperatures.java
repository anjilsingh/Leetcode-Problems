class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] output=new int[n];
        Stack<int[]>st=new Stack<>();
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