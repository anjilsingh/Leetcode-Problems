class Solution {
    public int[] finalPrices(int[] prices) {
        //next -> smaller
        //make an array;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            while(!st.isEmpty() && prices[st.peek()]>prices[i])
            st.pop();
            if(st.isEmpty())
            ans[i]=prices[i];
            else
            {
                ans[i]=prices[i]-prices[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
}